package com.jack.self.service.entry;

import com.jack.self.model.UserVO;

import java.util.List;

/**
 * 描述：查询医院信息service
 * 作者：Jack
 * 时间：2016/10/17 14:10
 * @version 1.0
 */

public interface QueryUserService {
    List<UserVO> queryUser();
}
