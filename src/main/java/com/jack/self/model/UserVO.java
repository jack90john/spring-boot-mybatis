package com.jack.self.model;

import lombok.Data;

/**
 * 描述：用户model
 * 作者：Jack
 * 时间：2016/10/18 16:37
 * @version 1.0
 */
@Data
public class UserVO {

    private Integer id;

    private String userName;

    private String password;

    private String role;

    private Integer status;

}
