package com.jack.self.mapper;

import com.jack.self.model.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 描述：医院查询mapper
 * 作者：Jack
 * 时间：2016/10/17 14:10
 * @version 1.0
 */

@Component
public interface UserMapper {
    List<UserVO> queryUser();

    UserVO queryUserByName(@Param("userName") String userName);
}
