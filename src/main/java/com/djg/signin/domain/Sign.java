package com.djg.signin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.djg.signin.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.Serializable;
import java.util.Date;

/**
 * @NAME: Sign
 * @author: DaiJianG
 * @DATE: 2021/10/1
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sign implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    @Excel(name = "ID")
    @ApiModelProperty(value = "ID",required = false)
    private Integer id ;

    @Excel(name = "用户ID")
    @ApiModelProperty(value = "用户ID",required = false)
    private Integer userId;

    @Excel(name = "用户名称")
    @ApiModelProperty(value = "用户名称",required = false)
    private String userName;


    @Excel(name = "签到时间" , dateFormat = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "签到时间",required = false)
    private Date signInTime;


    @Excel(name = "签退时间" , dateFormat = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "签退时间",required = false)
    private Date signOutTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间",required = false)
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间",required = false)
    private Date endTime;



}