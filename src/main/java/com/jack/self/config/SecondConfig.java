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
 * 描述：
 * 作者：Jack
 * 时间：2016/11/9 16:52
 *
 * @version 1.0
 */
@Configuration
@EnableTransactionManagement
public class SecondConfig {

    @Bean
    @ConfigurationProperties(prefix = "secondConnect")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "secondSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("com.jack.self.model.second");
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
//            Resource[] resources = (Resource[]) ArrayUtils.addAll(resolver.getResources("classpath:mapper/link/*.xml"),
//                    resolver.getResources("classpath:mapper/link/ext/*.xml"));
            Resource[] resources =
                    resolver.getResources("classpath:mapper/second/*.xml");
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