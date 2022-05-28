package com.github.viqbgrg.easypoi.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import lombok.Data;

/**
 * @author bing
 */
@Data
public class ExcelPojo1 implements java.io.Serializable{
    @Excel(name = "序号")
    private Integer index;
    @Excel(name = "编 码")
    private String code;
    @Excel(name = "项目名称")
    private String name;
    @ExcelEntity(name = "金 额(元)", show = true)
    private Fee fee;
}
