package com.github.viqbgrg.easypoi.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 * @author bing
 */
@Data
@ExcelTarget("fee")
public class Fee {
    @Excel(name = "综合单价")
    private Double zhongHe;
    @Excel(name = "合 价")
    private Double total;
    @ExcelEntity(name = "其 中", show = true)
    private Other other;
}
