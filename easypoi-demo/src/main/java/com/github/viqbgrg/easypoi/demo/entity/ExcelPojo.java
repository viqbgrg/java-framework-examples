package com.github.viqbgrg.easypoi.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author bing
 */
@Data
public class ExcelPojo implements java.io.Serializable{
    @Excel(name = "序号")
    private Integer index;
    @Excel(name = "编 码")
    private String code;
    @Excel(name = "项目名称")
    private String name;
    @Excel(name = "综合单价", groupName = "金 额(元)")
    private Double zhongHe;
    @Excel(name = "合 价")
    private Double total;
    @Excel(name = "人工费", groupName = "其 中")
    private Double renGong;
    @Excel(name = "材料及工程设备暂估价")
    private Double cai;
}
