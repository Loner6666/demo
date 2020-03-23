package com.example.demo.services.impl;

import com.example.demo.bean.UserInfo;
import com.example.demo.common.ResultObject;
import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.services.UserInfoServices;
import com.example.demo.vo.UserInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：Administrator
 * @Description：gmall数据库中的user_info，实现类
 * @data：2020:03:13
 */
@Slf4j
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

    /**
     * 修改UserInfo信息
     * * URL：/gmall/updateUser
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @Override
    public ResultObject updateUser(UserInfo userInfo) throws Exception {
        int i = this.userInfoMapper.updateByPrimaryKeySelective(userInfo);
        String msg = "成功修改：" + i + "条！";
        log.info(msg);
        return ResultObject.successMsg(msg);
    }

    /**
     * 插入UserInfo信息
     * * URL：/gmall/insertUser
     *
     * @param userInfo
     * @return ResultObject
     * @throws Exception
     */
    @Override
    public ResultObject insertUser(UserInfo userInfo) throws Exception {
        //1、先根据条件查询，是否已存在
        UserInfo selectBySelective = this.userInfoMapper.selectBySelective(userInfo);
        if (null != selectBySelective) {
            log.info("数据已存在，不能重复插入！");
            return ResultObject.error("数据已存在，不能重复插入！");
        }
        //2、数据不存在，则插入
        int i = this.userInfoMapper.insertSelective(userInfo);
        String msg = "成功插入：" + i + "条！";
        log.info(msg);
        return ResultObject.successMsg(msg);
    }

}
