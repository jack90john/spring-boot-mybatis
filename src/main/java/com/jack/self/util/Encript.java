package com.jack.self.util;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEBigDecimalEncryptor;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

/**
 * 描述：
 * 作者：Jack
 * 时间：2016/10/31 15:40
 *
 * @version 1.0
 */
public class Encript {
    static StringEncryptor stringEncryptor() {
       /** PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("password");
        config.setAlgorithm(StandardPBEByteEncryptor.DEFAULT_ALGORITHM);
        config.setKeyObtentionIterations(StandardPBEByteEncryptor.DEFAULT_KEY_OBTENTION_ITERATIONS);
        config.setPoolSize(StandardPBEByteEncryptor.DEFAULT_SALT_SIZE_BYTES);
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
*/
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("password");
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }

    public static void main(String[] args) {
        String str = stringEncryptor().encrypt("jdbc:mysql://insurancetest1.mysql.rds.aliyuncs.com:3306/insurance_link?autoReconnect=true&useUnicode=true&characterEncoding=utf8&useSSL=false");
        String str1 = stringEncryptor().decrypt("FHQIpbK0S2NJNQSnQwcGmg3jt5lyX2nj");
        System.out.println(str);
        System.out.println(str1);
    }
}
