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
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

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

    @Autowired
    private JedisCluster jedis;

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

    /**
     * 根据id查询UserInfo
     * * URL：/gmall/user/{id}
     *
     * @param id
     * @return ResultObject
     * @throws Exception
     */
    @Override
    public ResultObject selectByPrimaryKey(Long id) throws Exception {
        String key = "USERIFNO_ID_" + id;
        String value = null;
        log.info("==UserInfoServicesImpl.selectByPrimaryKey.request【{}】", id);

//        if (jedis.exists(key)) {
//            //如果Redis中有，直接返回
//            value = jedis.get(key);
//            log.info("从Redis中返回：【{}】", value);
//        } else {
//            //第一次从数据库查询，并存入Redis
//            UserInfo userInfo = this.userInfoMapper.selectByPrimaryKey(id);
//            value = JSON.toJSONString(userInfo);
//            //过期时间一分钟
//            jedis.setex(key, 60 * 1, value);
//            log.info("第一次从数据库查询：【{}】", value);
//        }
        UserInfo userInfo = this.userInfoMapper.selectByPrimaryKey(id);
        return ResultObject.successData(userInfo);
    }

    /**
     * 根据id删除UserInfo
     * * URL: /delete/user/{id}
     *
     * @param id 用户id
     * @return ResultObject
     * @throws Exception
     */
    @Override
    public ResultObject deleteUserById(Long id) throws Exception {
        int deleteByPrimaryKey = this.userInfoMapper.deleteByPrimaryKey(id);
        String mes = "成功删除：" + deleteByPrimaryKey + " 条数据！";
        return ResultObject.successData(mes);
    }

    /**
     * 导出到CSV文件
     *
     * @param request
     * @param response
     */
    @Override
    public void exportCsv(HttpServletRequest request, HttpServletResponse response) {
        List<UserInfo> userInfoList = userInfoMapper.getUserInfo();
        BufferedWriter csvFileOutputStream = null;
        String fileName = "导出CSV文件test";
        List exportData = new ArrayList<Map>();
        if (!CollectionUtils.isEmpty(userInfoList)) {
            Map row = new LinkedHashMap<String, String>();
            for (UserInfo userInfo : userInfoList) {
                row.put("1", userInfo.getId());
                row.put("2", userInfo.getLoginName());
                row.put("3", userInfo.getNickName());
                row.put("4", userInfo.getPasswd());
                row.put("5", userInfo.getName());
                row.put("6", userInfo.getPhoneNum());
                row.put("7", userInfo.getEmail());
                row.put("8", userInfo.getHeadImg());
                row.put("9", userInfo.getUserLevel());
                exportData.add(row);
                row = new LinkedHashMap<String, String>();
            }
        }
        //设置列名
        LinkedHashMap map = new LinkedHashMap();
        map.put("1", "编号");
        map.put("2", "用户名称");
        map.put("3", "用户昵称");
        map.put("4", "用户密码");
        map.put("5", "用户姓名");
        map.put("6", "手机号");
        map.put("7", "邮箱");
        map.put("8", "头像");
        map.put("9", "用户级别");
        try {
            File csvFile = csvFile = new File(fileName + ".csv");
            //UTF-8使正确读取分隔符","
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8"), 1024);
            //写入前段字节流，防止乱码
            csvFileOutputStream.write(getBOM());
            //写入文件头部
            for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext(); ) {
                java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
                csvFileOutputStream.write((String) propertyEntry.getValue() != null ? (String) propertyEntry.getValue() : "");
                if (propertyIterator.hasNext()) {
                    csvFileOutputStream.write(",");
                }
            }
            //换行
            csvFileOutputStream.newLine();
            //写入文件内容
            for (Iterator iterator = exportData.iterator(); iterator.hasNext(); ) {
                Object row = (Object) iterator.next();
                for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext(); ) {
                    java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
                    String str = row != null ? (String.valueOf(((Map) row).get(propertyEntry.getKey()))) : "";

                    if (Objects.isNull(str)) {
                        str = "";
                    } else {
                        str = str.replaceAll("\"", "\"\"");
                        if (str.indexOf(",") >= 0) {
                            str = "\"" + str + "\"";
                        }
                    }
                    csvFileOutputStream.write(str);
                    if (propertyIterator.hasNext()) {
                        csvFileOutputStream.write(",");
                    }
                }
                if (iterator.hasNext()) {
                    csvFileOutputStream.newLine();
                }
            }
            csvFileOutputStream.flush();
            //浏览器导出
            InputStream in = new FileInputStream(csvFile);
            int len = 0;
            byte[] buffer = new byte[1024];
            OutputStream out = response.getOutputStream();
            response.reset();
            response.setContentType("application/csv;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName + ".csv", "UTF-8"));
            response.setCharacterEncoding("UTF-8");
            while ((len = in.read(buffer)) > 0) {
                out.write(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF});
                out.write(buffer, 0, len);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.info("导出SCV异常", e);
        } finally {
            try {
                csvFileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("导出SCV成功");
    }

    /**
     * 功能说明：获取UTF-8编码文本文件开头的BOM签名。
     * BOM(Byte Order Mark)，是UTF编码方案里用于标识编码的标准标记。例：接收者收到以EF BB BF开头的字节流，就知道是UTF-8编码。
     *
     * @return UTF-8编码文本文件开头的BOM签名
     */
    public static String getBOM() {
        byte b[] = {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};
        return new String(b);
    }

}
