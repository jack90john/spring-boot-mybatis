package com.jack.self.config;

/**
 * 任务：
 * 描述：
 * 作者：蒋珂
 * 时间：2016/10/20 10:39
 * 类名: spring-boot-mybatis
 *
 * @version 1.0
 */
public enum  EnumAuth {
    DEFAULT_AUTH("00000");

    private String defaultAuth;

    EnumAuth(String defaultAuth){
        this.defaultAuth = defaultAuth;
    }

    public String getDefaultAuth() {
        return defaultAuth;
    }
}
