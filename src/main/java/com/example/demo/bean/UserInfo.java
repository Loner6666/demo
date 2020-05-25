package com.example.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * gmall数据库中的user_info
 */
@Data//getter、setter方法
@AllArgsConstructor//全参构造器
@NoArgsConstructor//无参构造器
@ApiModel(value = "user对象", description = "用户对象user")
public class UserInfo {

    @ApiModelProperty(value = "用户id", name = "id", example = "4")
    private Long id;//编号
    @ApiModelProperty(value = "用户名称", name = "loginName", example = "用户4")
    private String loginName;//用户名称
    @ApiModelProperty(value = "用户昵称", name = "nickName", example = "昵称4")
    private String nickName;//用户昵称
    @ApiModelProperty(value = "用户密码", name = "passwd", example = "202cb962ac59075b964b07152d234b70")
    private String passwd;//用户密码
    @ApiModelProperty(value = "用户姓名", name = "name", example = "张三004")
    private String name;//用户姓名
    @ApiModelProperty(value = "手机号", name = "phoneNum", example = "17300001114")
    private String phoneNum;//手机号
    @ApiModelProperty(value = "邮箱", name = "email", example = "17300001114@qq.com")
    private String email;//邮箱
    @ApiModelProperty(value = "头像", name = "headImg", example = "4")
    private String headImg;//头像
    @ApiModelProperty(value = "用户级别", name = "userLevel", example = "4")
    private String userLevel;//用户级别

}