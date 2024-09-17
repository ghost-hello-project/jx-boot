package com.laolang.jx;

import cn.hutool.core.date.DatePattern;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laolang.jx.framework.common.domain.R;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@Slf4j
@Profile("dev")
@SpringBootTest
public class CommonTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ObjectMapper objectMapper;

    @SneakyThrows
    @Test
    public void testOne() {
        R<Object> r = R.error();
        JSONConfig jsonConfig = JSONConfig.create();
        jsonConfig.setDateFormat(DatePattern.NORM_DATETIME_PATTERN);
        log.info("{}", JSONUtil.toJsonStr(r, jsonConfig));
        log.info("{}", objectMapper.writeValueAsString(r));

    }
}
