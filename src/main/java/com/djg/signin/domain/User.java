package com.djg.signin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.djg.signin.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @NAME: User
 * @author: DaiJianG
 * @DATE: 2021/9/30
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    @Excel(name = "用户ID")
    @ApiModelProperty(value = "ID",required = false)
    private Integer id ;

    @Excel(name = "用户名称")
    @ApiModelProperty(value = "用户名称",required = true)
    private String name;

    @Excel(name = "性别")
    @ApiModelProperty(value = "性别",required = true)
    private String sex;


    @Excel(name = "该月累计天数")
    @ApiModelProperty(value = "该月累计天数",required = false)
    private Integer cumulateDaysMonth;


    @Excel(name = "总累计天数")
    @ApiModelProperty(value = "总累计天数",required = false)
    private Integer totalDays;


}
