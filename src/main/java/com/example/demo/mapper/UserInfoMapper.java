package com.example.demo.mapper;

import com.example.demo.bean.UserInfo;
import com.example.demo.vo.UserInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * gmall数据库中的user_info，mapper
 */
public interface UserInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**
     * 查询user_info所有数据
     * * URL： /gmall/getUserInfo
     *
     * @return
     */
    //    @Select("select * from user_info")//用注解可以直接执行简单的SQL语句
    List<UserInfo> getUserInfo();

    /**
     * 分页查询user_info
     * * URL： /gmall/getUserInfoPage
     *
     * @param request
     * @return
     */
    List<UserInfoVo> getUserInfoPage(UserInfoVo request);

    /**
     * user_info从Excel中导入到数据库
     * * * URL： /gmall/importUserInfo
     *
     * @param userInfoList
     * @return
     */
    Integer importUserInfoList(@Param(value = "list") List<UserInfo> userInfoList);

}