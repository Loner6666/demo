package com.example.demo.controller;


import com.alibaba.fastjson.JSON;
import com.example.demo.bean.UserInfo;
import com.example.demo.common.ResultObject;
import com.example.demo.services.UserInfoServices;
import com.example.demo.vo.UserInfoVo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author：Administrator
 * @Description：gmall数据库中的user_info，控制器
 * @data：2020：03:13
 */
@Slf4j
@Api(description = "用户接口")
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoServices userInfoServices;

    /**
     * 查询user_info所有数据
     * URL： /gmall/getUserInfo
     * http://localhost:8081/gmall/getUserInfo
     *
     * @return
     */
    @ApiOperation(value = "查询用户信息", notes = "查询user_info所有数据", httpMethod = "GET")
    @RequestMapping("/getUserInfo")
    public ResultObject getUserInfo() {
        try {
            log.info("查询user_info所有数据，start————>");
            List<UserInfo> userInfoList = this.userInfoServices.getUserInfo();
            log.info("查询user_info所有数据，end————>{}", JSON.toJSONString(userInfoList));
            return ResultObject.successData(userInfoList);
        } catch (Exception e) {
            log.info("查询user_info所有数据，error————>[{},{}]", e.getMessage(), e);
            e.printStackTrace();
            return ResultObject.error("系统异常！");
        }
    }

    /**
     * 根据id查询UserInfo
     * URL：/gmall/user/{id}
     * http://localhost:8081/gmall/user/1
     *
     * @param id
     * @return ResultObject
     */
    @ApiOperation(value = "查询指定用户信息", notes = "根据id查询UserInfo", httpMethod = "GET")
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "用户ID", required = true, dataType = "Long", example = "1")
    )
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResultObject getUserById(@PathVariable Long id) {
        try {
            log.info("根据id查询UserInfo，start————>{}", JSON.toJSONString(id));
            ResultObject responseData = this.userInfoServices.selectByPrimaryKey(id);
            log.info("根据id查询UserInfo，end————>{}", JSON.toJSONString(responseData));
            return responseData;
        } catch (Exception e) {
            log.info("根据id查询UserInfo，error————>[{},{}]", e.getMessage(), e);
            e.printStackTrace();
            return ResultObject.error("查询失败！");
        }
    }

    /**
     * 分页查询user_info
     * URL： /gmall/getUserInfoPage
     * http://localhost:8081/gmall/getUserInfoPage
     * {
     * "pageNum": 1,
     * "pageSize": 2
     * }
     *
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询user_info", httpMethod = "POST")
    @PostMapping(value = "/getUserInfoPage")
    public ResultObject getUserInfoPage(@RequestBody @ApiParam(name = "用户分页对象", value = "传入json格式", required = true) UserInfoVo request) {
        try {
            log.info("分页查询user_info，start————>{}", JSON.toJSONString(request));
            ResultObject responseData = this.userInfoServices.getUserInfoPage(request);
            log.info("分页查询user_info，end————>{}", JSON.toJSONString(responseData));
            return responseData;
        } catch (Exception e) {
            log.info("分页查询user_info，error————>[{},{}]", e.getMessage(), e);
            e.printStackTrace();
            return ResultObject.error("系统异常！");
        }
    }

    /**
     * 修改UserInfo信息
     * URL：/gmall/updateUser
     * http://localhost:8081/gmall/updateUser
     *
     * @param userInfo
     * @return
     */
    @ApiOperation(value = "修改用户信息", notes = "修改UserInfo信息", httpMethod = "POST")
    @PostMapping(value = "/updateUser")
    public ResultObject updateUser(@RequestBody @ApiParam(name = "用户对象", value = "传入json格式") UserInfo userInfo) {
        try {
            log.info("修改UserInfo信息，start————>{}", JSON.toJSONString(userInfo));
            ResultObject responseData = this.userInfoServices.updateUser(userInfo);
            log.info("修改UserInfo信息，end————>{}", JSON.toJSONString(responseData));
            return responseData;
        } catch (Exception e) {
            log.info("修改UserInfo信息，error————>【{},{}】", e.getMessage(), e);
            e.printStackTrace();
            return ResultObject.error("修改失败！");
        }
    }

    /**
     * 插入UserInfo信息
     * URL：/gmall/insertUser
     * http://localhost:8081/gmall/insertUser
     *
     * @param userInfo
     * @return ResultObject
     */
    @ApiOperation(value = "插入用户信息", notes = "插入UserInfo信息", httpMethod = "POST")
    @PostMapping(value = "/insertUser")
    public ResultObject insertUser(@RequestBody @ApiParam(name = "用户对象", value = "传入json格式") UserInfo userInfo) {
        try {
            log.info("插入UserInfo信息，start————>{}", JSON.toJSONString(userInfo));
            ResultObject responseData = this.userInfoServices.insertUser(userInfo);
            log.info("插入UserInfo信息，end————>{}", JSON.toJSONString(responseData));
            return responseData;
        } catch (Exception e) {
            log.info("插入UserInfo信息，error————>【{},{}】", e.getMessage(), e);
            e.printStackTrace();
            return ResultObject.error("插入失败！");
        }
    }

    /**
     * 数据导出到Excel
     * URL： /gmall/exportUserInfo
     * http://localhost:8081/gmall/exportUserInfo
     *
     * @return
     */
    @ApiOperation(value = "数据导出", notes = "数据导出到Excel", httpMethod = "GET")
    @GetMapping(value = "/exportUserInfo")
    public void exportUserInfo(HttpServletRequest request, HttpServletResponse response) {
        try {
            log.info("导出user_info到Excel，start————>");
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

            List<UserInfo> userInfoList = this.userInfoServices.getUserInfo();
            log.info("查询出要导出到Excel的数据————>date【{}】", JSON.toJSONString(userInfoList));

            if (!userInfoList.isEmpty()) {
                log.info("开始写入Excel文件");
                //创建excel文件
                XSSFWorkbook wb = new XSSFWorkbook();
                //创建sheet页
                XSSFSheet sheet = wb.createSheet("Sheet1");

                //创建标题行
                XSSFRow titleRow = sheet.createRow(0);
                titleRow.createCell(0).setCellValue("编号");
                titleRow.createCell(1).setCellValue("用户名称");
                titleRow.createCell(2).setCellValue("用户昵称");
                titleRow.createCell(3).setCellValue("用户密码");
                titleRow.createCell(4).setCellValue("用户姓名");
                titleRow.createCell(5).setCellValue("手机号");
                titleRow.createCell(6).setCellValue("邮箱");
                titleRow.createCell(7).setCellValue("头像");
                titleRow.createCell(8).setCellValue("用户级别");
                titleRow.createCell(9).setCellValue("导入时间");


                //遍历将数据放到excel列中
                for (UserInfo userInfo : userInfoList) {
                    XSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
                    dataRow.createCell(0).setCellValue(userInfo.getId());
                    dataRow.createCell(1).setCellValue(userInfo.getLoginName());
                    dataRow.createCell(2).setCellValue(userInfo.getNickName());
                    dataRow.createCell(3).setCellValue(userInfo.getPasswd());
                    dataRow.createCell(4).setCellValue(userInfo.getName());
                    dataRow.createCell(5).setCellValue(userInfo.getPhoneNum());
                    dataRow.createCell(6).setCellValue(userInfo.getEmail());
                    dataRow.createCell(7).setCellValue(userInfo.getHeadImg());
                    dataRow.createCell(8).setCellValue(userInfo.getUserLevel());
                    java.lang.String createTime = sdf.format(System.currentTimeMillis());
                    dataRow.createCell(9).setCellValue(createTime);
                }
                // 设置下载时客户端Excel的名称
                java.lang.String filename = new SimpleDateFormat("yyyyMMdd").format(new Date()) + "-导入失败记录-UserInfo.xlsx";
                //设置下载的文件
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-disposition", "attachment;filename=" + filename);
                OutputStream ouputStream = response.getOutputStream();//打开流
                wb.write(ouputStream); //在excel内写入流
                ouputStream.flush();// 刷新流
                ouputStream.close();// 关闭流
                log.info("Excel文件写入完成");
            }

            log.info("导出成功！");
        } catch (Exception e) {
            log.info("导出user_info到Excel，error————>[{},{}]", e.getMessage(), e);
            e.printStackTrace();
            log.error("导出异常！");
        }
    }

    /**
     * 数据导入到数据库
     * URL： /gmall/importUserInfo
     * http://localhost:8081/gmall/importUserInfo
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "数据导入", notes = "数据导入到数据库", httpMethod = "POST", produces = "application/octet-stream")
    @PostMapping("/importUserInfo")
    public ResultObject importUserInfo(@RequestParam(required = true) @ApiParam(name = "file", value = "要导入的excel文件") MultipartFile file) throws Exception {
        log.info("数据导入到数据库 开始——》{}");

        // 校验文件名
        isValidateFile(file);

        // 数据合法，可以插入的list
        List<UserInfo> userInfoList = new ArrayList<>();
        // 数据不合法，errUserList,并记录所在行数
        StringBuffer errNums = new StringBuffer("错误行数：第");
        List<UserInfo> errUserList = new ArrayList<>();

        Workbook workbook = null;

        try {
            java.lang.String fileName = file.getOriginalFilename();
            log.info("UserInfo批量导入,文件名——》{}" + fileName);
            workbook = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheet("Sheet1");
            int rows = sheet.getLastRowNum();// 指的行数，一共有多少行+
            if (rows == 0) {
                throw new Exception("暂无数据，请填写数据");
            }
            for (int i = 1; i <= rows + 1; i++) {
                // 读取左上端单元格
                Row row = sheet.getRow(i);
                // 行不为空
                if (row != null) {
                    // **读取cell**
                    UserInfo userInfo = new UserInfo();
                    // 按行读取userInfo对象,列是userInfo的属性

                    //用户名称
                    java.lang.String loginName = new java.lang.String();
                    //用户昵称
                    java.lang.String nickName = new java.lang.String();
                    //用户密码
                    java.lang.String passwd = new java.lang.String();
                    //用户姓名
                    java.lang.String name = new java.lang.String();
                    //手机号
                    java.lang.String phoneNum = new java.lang.String();
                    //邮箱
                    java.lang.String email = new java.lang.String();
                    //头像
                    java.lang.String headImg = new java.lang.String();
                    //用户级别
                    java.lang.String userLevel = new java.lang.String();


                    Cell cell0 = row.getCell(0);
                    cell0.setCellType(cell0.CELL_TYPE_STRING);
                    Cell cell1 = row.getCell(1);
                    Cell cell2 = row.getCell(2);
                    Cell cell3 = row.getCell(3);
                    Cell cell4 = row.getCell(4);
                    Cell cell5 = row.getCell(5);
                    Cell cell6 = row.getCell(6);
                    Cell cell7 = row.getCell(7);

                    // 数据空值校验,有空放 errobuVoList
                    if (null == cell0 || null == cell1 || null == cell2 || null == cell3 || null == cell4 || null == cell5
                            || null == cell6 || null == cell7) {
                        // 把一行数据赋值给userInfo
                        if (null == cell0) {
                            userInfo.setLoginName(loginName);
                        } else {
                            userInfo.setLoginName(cell0.toString());
                        }
                        if (null == cell1) {
                            userInfo.setNickName(nickName);
                        } else {
                            userInfo.setNickName(cell1.toString());
                        }
                        if (null == cell2) {
                            userInfo.setPasswd(passwd);
                        } else {
                            userInfo.setPasswd(cell2.toString());
                        }
                        if (null == cell3) {
                            userInfo.setName(name);
                        } else {
                            userInfo.setName(cell3.toString());
                        }
                        if (null == cell4) {
                            userInfo.setPhoneNum(phoneNum);
                        } else {
                            userInfo.setPhoneNum(cell4.toString());
                        }
                        if (null == cell5) {
                            userInfo.setEmail(email);
                        } else {
                            userInfo.setEmail(cell5.toString());
                        }
                        if (null == cell6) {
                            userInfo.setHeadImg(headImg);
                        } else {
                            userInfo.setHeadImg(row.getCell(6).toString());
                        }
                        if (null == cell7) {
                            userInfo.setUserLevel(userLevel);
                        } else {
                            userInfo.setHeadImg(row.getCell(7).toString());
                        }
                        errNums.append((row.getRowNum() + 1) + "行，");
                        errUserList.add(userInfo);
                    } else {
                        // 数据合法，加入list
                        // 把一行数据赋值给obu
                        userInfo.setLoginName(cell0.toString());
                        userInfo.setNickName(cell1.toString());
                        userInfo.setPasswd(cell2.toString());
                        userInfo.setName(cell3.toString());
                        userInfo.setPhoneNum(cell4.toString());
                        userInfo.setEmail(cell5.toString());
                        userInfo.setHeadImg(cell6.toString());
                        userInfo.setUserLevel(cell7.toString());
                        userInfoList.add(userInfo);
                    }
                }
            }

            Integer i = this.userInfoServices.importUserInfoList(userInfoList);

            log.info("没有导入的数据：" + errNums + ",errUserList" + errUserList);
            log.info("导入成功：" + userInfoList.size() + ",userInfoList" + userInfoList);

            return ResultObject.successMsg("导入成功！");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("UserInfo批量导入异常——》[{},{}]", e.getMessage(), e);
            return ResultObject.error("导入失败！");
        }
    }


    /**
     * 判断文件格式是否正确
     *
     * @param multipartFile
     */
    private void isValidateFile(MultipartFile multipartFile) throws Exception {
        if (multipartFile.isEmpty()) {
            throw new Exception("文件格式不正确");
        }
        java.lang.String fileName = multipartFile.getOriginalFilename();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            log.error("请按模板格式进行上传!");
            throw new Exception("模板不正确");
        }
    }


}
