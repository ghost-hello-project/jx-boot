package com.laolang.jx.module.system.api.dict.consts;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class SysUserLoginLogConsts {

    @Getter
    @AllArgsConstructor
    public enum LoginType {
        logout("00", "退出"),
        pc_account("01", "pc端账号密码登录"),
        pc_qr("02", "pc端扫码登录"),
        pc_wx("03", "pc端微信登录"),
        pc_qq("04", "pc端qq登录"),
        mobile("11", "移动端登录"),
        h5("21", "h5登录"),
        wx_("31", "微信小程序登录");
        private final String value;
        private final String desc;

        private static final Map<String, LoginType> value_map = Maps.newHashMap();


        static {
            for (LoginType e : values()) {
                value_map.put(e.getValue(), e);
            }
        }

        public static LoginType getByValue(String value) {
            return value_map.get(value);
        }
    }
}
