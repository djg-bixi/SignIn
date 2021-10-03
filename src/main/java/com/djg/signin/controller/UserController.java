package com.djg.signin.controller;

import com.djg.signin.common.excel.ExcelUtil;
import com.djg.signin.common.result.Response;
import com.djg.signin.domain.Sign;
import com.djg.signin.domain.User;
import com.djg.signin.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.nio.ch.SelectorImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @NAME: UserController
 * @author: DaiJianG
 * @DATE: 2021/10/1
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 导出 会下载到本地 当前目录的download 文件夹里
     * @param user
     * @return
     */
    @ApiOperation(value = "签到详情导出")
    @RequestMapping(value = "/export",method = RequestMethod.GET)
    public Response export(User user) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Response response = Response.getResponse();
        ExcelUtil<User> util = new ExcelUtil<>(User.class);
        List<User> users = userService.selectList(user);
        String url = util.exportExcel(users, sdf.format(new Date())+"userList");
        response.setResult("download/" + url);
        return response;
    }

}
