package com.github.viqbgrg.demo.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentLoopMerge;
import com.alibaba.excel.annotation.write.style.OnceAbsoluteMerge;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@OnceAbsoluteMerge(firstRowIndex = 11, lastRowIndex = 11, firstColumnIndex = 0, lastColumnIndex = 1)
public class DemoData1 {
    @ColumnWidth(100)
    private String name;
    @ExcelProperty(index = 2)
    private Double total;
}