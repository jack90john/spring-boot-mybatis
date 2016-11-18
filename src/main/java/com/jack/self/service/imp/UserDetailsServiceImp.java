package com.jack.self.service.imp;

import com.jack.self.mapper.UserMapper;
import com.jack.self.model.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 描述：密码验证
 * 作者：Jack
 * 时间：2016/10/19 17:04
 * 类名: spring-boot-mybatis
 *
 * @version 1.0
 */
@Slf4j
@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserVO userInfo = userMapper.queryUserByName(userName);

        if (userInfo == null) {
            log.info("用户名或密码错误！");
            throw new UsernameNotFoundException("用户名或密码错误！");
        }
        String[] roles = StringUtils.split(userInfo.getRole(), ",");
        UserDetails userDetails = new User(userInfo.getUserName(), userInfo.getPassword(), AuthorityUtils.createAuthorityList(roles));
//Long.parseLong()
        return userDetails;
    }
}
