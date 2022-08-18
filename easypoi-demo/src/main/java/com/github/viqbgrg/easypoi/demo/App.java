package com.github.viqbgrg.easypoi.demo;

import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.imports.ExcelImportService;
import com.github.viqbgrg.easypoi.demo.entity.ExcelPojo;
import com.github.viqbgrg.easypoi.demo.entity.ExcelPojo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * @author bing
 */
public class App {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("C:\\Users\\viqbg\\Desktop\\test2(1).xlsx");
        ImportParams params = new ImportParams();
        params.setTitleRows(2);
        params.setHeadRows(3);
        List<ExcelPojo> list = new ExcelImportService().importExcelByIs(inputStream, ExcelPojo.class, params, false).getList();
        for (ExcelPojo excelPojo : list) {
            System.out.println(excelPojo.toString());
        }
    }
}
