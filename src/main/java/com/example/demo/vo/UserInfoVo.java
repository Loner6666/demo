package com.example.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author：Administrator
 * @Description：gmall数据库中的user_info VO
 * @data：2020:03:13
 */
@Data
@ApiModel(value = "分页user对象", description = "用户对象user分页查询的入参")
public class UserInfoVo {

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


    @ApiModelProperty(value = "分页起始条", name = "pageNum", example = "1")
    private Integer pageNum; // 分页起始条
    @ApiModelProperty(value = "每页显示条数", name = "pageSize", example = "3")
    private Integer pageSize; // 每页显示条数
    @ApiModelProperty(value = "总条数", name = "pageTotal", example = "")
    private Integer pageTotal; // 总条数

}
