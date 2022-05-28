package com.github.viqbgrg.easypoi.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

/**
 * @author bing
 */
@Data
@ExcelTarget("other")
public class Other {
    @Excel(name = "人工费")
    private Double renGong;
    @Excel(name = "材料及工程设备暂估价")
    private Double cai;
}
