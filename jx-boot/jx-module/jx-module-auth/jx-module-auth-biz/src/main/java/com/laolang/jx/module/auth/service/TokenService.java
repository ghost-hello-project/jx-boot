package com.laolang.jx.module.auth.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.laolang.jx.framework.common.consts.GlobalConst;
import com.laolang.jx.framework.common.util.IpUtil;
import com.laolang.jx.framework.common.util.ServletKit;
import com.laolang.jx.framework.redis.util.RedisUtil;
import com.laolang.jx.module.auth.dto.LoginUserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TokenService {
    private final RedisUtil redisUtil;

    /**
     * 令牌自定义标识
     */
    @Value("${token.header}")
    private String header;

    /**
     * 令牌秘钥
     */
    @Value("${token.secret}")
    private String secret;

    /**
     * 令牌有效期（默认30分钟）
     */
    @Value("${token.expireTime}")
    private int expireTime;

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    public LoginUserDto getLoginUser(HttpServletRequest request) {
        String token = getToken(request);
        if (StrUtil.isNotBlank(token)) {
            Claims claims = parseToken(token);
            String username = (String) claims.get(GlobalConst.LOGIN_USER_KEY);
            String userKey = getTokenKey(username);
            return redisUtil.getCacheObject(userKey);
        }
        return null;
    }

    private Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (StrUtil.isNotEmpty(token) && token.startsWith(GlobalConst.TOKEN_PREFIX)) {
            token = token.replace(GlobalConst.TOKEN_PREFIX, "");
        }
        return token;
    }

    public String createToken(LoginUserDto loginUser) {
        setUserAgent(loginUser);
        refreshToken(loginUser);
        Map<String, Object> claims = new HashMap<>();
        claims.put(GlobalConst.LOGIN_USER_KEY, loginUser.getSysUser().getUsername());
        return createToken(claims);
    }

    public String createToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    private void refreshToken(LoginUserDto loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + expireTime * MILLIS_MINUTE);
        String userKey = getTokenKey(loginUser.getUsername());
        redisUtil.setCacheObject(userKey, loginUser, expireTime, TimeUnit.MINUTES);
    }

    public void removeToken(LoginUserDto loginUser){
        redisUtil.del(getTokenKey(loginUser.getUsername()));
    }

    private String getTokenKey(String username) {
        return GlobalConst.LOGIN_TOKEN_KEY + username;
    }

    private void setUserAgent(LoginUserDto loginUser) {
        UserAgent userAgent = UserAgentUtil.parse(ServletKit.getRequest().getHeader("User-Agent"));
        String ip = IpUtil.getIpAddr(ServletKit.getRequest());
        loginUser.getSysUser().setLoginIp(ip);
    }

    public void verifyToken(LoginUserDto loginUser) {
        long expireTime = loginUser.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= MILLIS_MINUTE_TEN) {
            refreshToken(loginUser);
        }
    }
}
