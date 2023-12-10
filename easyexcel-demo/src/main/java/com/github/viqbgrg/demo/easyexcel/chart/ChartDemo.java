package com.github.viqbgrg.demo.easyexcel.chart;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.github.viqbgrg.demo.easyexcel.DemoData;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ChartDemo {

    public static void main(String[] args) throws IOException {
        String fileName = "/home/bing/excelTest/" + "customHandlerWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoData.class)
                .registerWriteHandler(new CustomCellWriteHandler()).sheet("模板").doWrite(data());
        Runtime.getRuntime()
                .exec(String.format("xdg-open %s", fileName));
    }

    private static List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

}
