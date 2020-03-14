package com.example.demo.bean;

import lombok.Data;

/**
 * gmall数据库中的user_info
 */
@Data
public class UserInfo {

    private Long id;//编号
    private String loginName;//用户名称
    private String nickName;//用户昵称
    private String passwd;//用户密码
    private String name;//用户姓名
    private String phoneNum;//手机号
    private String email;//邮箱
    private String headImg;//头像
    private String userLevel;//用户级别

}