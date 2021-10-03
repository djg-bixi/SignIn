package com.djg.signin.controller;

import com.djg.signin.common.excel.ExcelUtil;
import com.djg.signin.common.result.Response;
import com.djg.signin.common.constant.ResponseCode;
import com.djg.signin.domain.Sign;
import com.djg.signin.service.SignService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @NAME: SignController
 * @author: DaiJianG
 * @DATE: 2021/10/1
 **/
@RestController
@RequestMapping("/sign")
public class SignController {
    @Autowired
    SignService signService;

    /**
     * 签到
     * @param sign
     * @return
     */
    @ApiOperation(value = "用户签到")
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public Response signIn(Sign sign) {
        Response response = Response.getResponse();
        Integer res = signService.signIn(sign);
        response.setResult(res);
        if (res == -1) {
            response.setResp(ResponseCode.OPERATION_FAILED, ResponseCode.MISSING_USER_MESSAGE,false);
        }else if (res == -2){
            response.setResp(ResponseCode.OPERATION_FAILED, ResponseCode.REPEAT_SIGN_IN_MESSAGE,false);
        }else {
            response.setResp(ResponseCode.OPERATION_SUCCESS, ResponseCode.SUCCESS_MESSAGE);
        }
        return response;
    }

    /**
     * 签退
     * @param sign
     * @return
     */
    @ApiOperation(value = "用户签退")
    @RequestMapping(value = "/signout", method = RequestMethod.POST)
    public Response signOut(Sign sign) {
        Response response = Response.getResponse();
        Integer res = signService.signOut(sign);
        response.setResult(res);
        if (res == -1) {
            response.setResp(ResponseCode.OPERATION_FAILED, ResponseCode.FAIL_SIGN_OUT_MESSAGE,false);
        }else {
            response.setResp(ResponseCode.OPERATION_SUCCESS, ResponseCode.SUCCESS_MESSAGE);
        }
        return response;
    }


    /**
     * 导出 会下载到本地 当前目录的download 文件夹里
     * @param sign
     * @return
     */
    @ApiOperation(value = "签到详情导出")
    @RequestMapping(value = "/export",method = RequestMethod.GET)
    public Response export(Sign sign) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Response response = Response.getResponse();
        ExcelUtil<Sign> util = new ExcelUtil<>(Sign.class);
        List<Sign> signs = signService.selectList(sign);
        String url = util.exportExcel(signs, sdf.format(new Date())+"signList");
        response.setResult("download/" + url);
        return response;
    }
}
