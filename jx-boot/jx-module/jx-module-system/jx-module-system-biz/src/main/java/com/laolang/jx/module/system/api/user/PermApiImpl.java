package com.laolang.jx.module.system.api.user;

import java.util.Collections;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PermApiImpl implements PermApi{
    @Override
    public Set<String> selectPersmByUsername(String username) {
        return null;
    }
}
