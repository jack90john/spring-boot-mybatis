package com.jack.self.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * 描述：Mybatis配置文件
 * 作者：Jack
 * 时间：2016/10/17 18:03
 * @version 1.0
 */
@Configuration
@EnableTransactionManagement
public class MybatisConfig {

    @Bean
    @ConfigurationProperties(prefix = "acceptanceConnect")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("com.jack.self.model");
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
//            Resource[] resources = (Resource[]) ArrayUtils.addAll(resolver.getResources("classpath:mapper/link/*.xml"),
//                    resolver.getResources("classpath:mapper/link/ext/*.xml"));
            Resource[] resources =
                    resolver.getResources("classpath:mapper/*.xml");
            sessionFactory.setMapperLocations(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory.getObject();
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
