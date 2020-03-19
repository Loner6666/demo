package com.example.demo.services.impl;

import com.example.demo.bean.UserInfo;
import com.example.demo.common.ResultObject;
import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.services.UserInfoServices;
import com.example.demo.vo.UserInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：Administrator
 * @Description：gmall数据库中的user_info，实现类
 * @data：2020:03:13
 */
@Service
public class UserInfoServicesImpl implements UserInfoServices {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 查询user_info所有数据
     * * URL： /gmall/getUserInfo
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfo> getUserInfo() throws Exception {
        List<UserInfo> userInfo = this.userInfoMapper.getUserInfo();
        return userInfo;
    }

    /**
     * 分页查询user_info
     * * URL： /gmall/getUserInfoPage
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public ResultObject getUserInfoPage(UserInfoVo request) throws Exception {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<UserInfoVo> userInfoList = this.userInfoMapper.getUserInfoPage(request);
        PageInfo<UserInfoVo> pageInfo = new PageInfo(userInfoList);
        return ResultObject.successData(pageInfo);
    }

    /**
     * user_info从Excel中导入到数据库
     * * URL： /gmall/importUserInfo
     *
     * @param userInfoList
     * @return
     */
    @Override
    public Integer importUserInfoList(List<UserInfo> userInfoList) throws Exception {
        Integer i = this.userInfoMapper.importUserInfoList(userInfoList);
        return i;
    }

}
