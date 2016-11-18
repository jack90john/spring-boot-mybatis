package com.jack.self.config;

import com.jack.self.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletResponse;

/**
 * 描述：springSecurtiy配置文件
 * 作者：Jack
 * 时间：2016/10/19 11:08
 *
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /*通过 authorizeRequests() 定义哪些URL需要被保护、哪些不需要被保护。例如以上代码指定了 /  不需要任何认证就可以访问，其他的路径都必须通过身份验证*/
                .authorizeRequests()
                .antMatchers("/assets/**", "/login/**", "/css/**", "/js/**", "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
                /*通过 formLogin() 定义当需要用户登录时候，转到的登录页面。*/
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .rememberMe()
                .and()
                .csrf().disable();
//                .exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint())
//                .accessDeniedHandler(new DefaultAccessDeniedHandler());
    }

    /*configureGlobal(AuthenticationManagerBuilder auth) 方法，在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER。*/
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("USER");
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public AuthenticationEntryPoint unauthorizedEntryPoint() {
        return (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
