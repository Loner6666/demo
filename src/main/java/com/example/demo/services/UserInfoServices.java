package com.example.demo.services;

import com.example.demo.bean.UserInfo;
import com.example.demo.common.ResultObject;
import com.example.demo.vo.UserInfoVo;

import java.util.List;

/**
 * @author：Administrator
 * @Description：gmall数据库中的user_info，接口
 * @data：2020:03:13
 */
public interface UserInfoServices {

    /**
     * 查询user_info所有数据
     * * URL： /gmall/getUserInfo
     *
     * @return
     * @throws Exception
     */
    List<UserInfo> getUserInfo() throws Exception;

    /**
     * 分页查询user_info
     * * URL： /gmall/getUserInfoPage
     *
     * @param request
     * @return
     * @throws Exception
     */
    ResultObject getUserInfoPage(UserInfoVo request) throws Exception;

    /**
     * user_info从Excel中导入到数据库
     * * URL： /gmall/importUserInfo
     *
     * @param userInfoList
     * @return
     */
    Integer importUserInfoList(List<UserInfo> userInfoList) throws Exception;

    /**
     * 修改UserInfo信息
     * * URL：/gmall/updateUser
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    ResultObject updateUser(UserInfo userInfo) throws Exception;

    /**
     * 插入UserInfo信息
     * * URL：/gmall/insertUser
     *
     * @param userInfo
     * @return ResultObject
     * @throws Exception
     */
    ResultObject insertUser(UserInfo userInfo) throws Exception;

    /**
     * 根据id查询UserInfo
     * * URL：/gmall/user/{id}
     *
     * @param id
     * @return ResultObject
     * @throws Exception
     */
    ResultObject selectByPrimaryKey(Long id) throws Exception;

}
