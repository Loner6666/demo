package com.example.demo.vo;

import lombok.Data;

/**
 * @author：Administrator
 * @Description：gmall数据库中的user_info VO
 * @data：2020:03:13
 */
@Data
public class UserInfoVo {

    private Long id;//编号
    private String loginName;//用户名称
    private String nickName;//用户昵称
    private String passwd;//用户密码
    private String name;//用户姓名
    private String phoneNum;//手机号
    private String email;//邮箱
    private String headImg;//头像
    private String userLevel;//用户级别

    private Integer pageNum; // 分页起始条
    private Integer pageSize; // 每页显示条数
    private Integer pageTotal; // 总条数

}
