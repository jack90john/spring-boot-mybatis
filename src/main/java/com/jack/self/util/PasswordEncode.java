package com.jack.self.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 描述：密码加密工具
 * 作者：Jack
 * 时间：2016/10/19 17:57
 *
 * @version 1.0
 */
@Slf4j
public class PasswordEncode {
    public static void main(String... args) {
        BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
        String bpepassword = bpe.encode("zhangsan");
        log.info(bpepassword);
    }
}
