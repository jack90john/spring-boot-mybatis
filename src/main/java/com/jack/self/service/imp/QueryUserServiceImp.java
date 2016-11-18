package com.jack.self.service.imp;

import com.jack.self.mapper.UserMapper;
import com.jack.self.model.UserVO;
import com.jack.self.service.entry.QueryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：查询医院信息实现类
 * 作者：Jack
 * 时间：2016/10/17 15:38
 * @version 1.0
 */

@Service
public class QueryUserServiceImp implements QueryUserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public List<UserVO> queryUser() {
        return userMapper.queryUser();
    }
}
