package com.github.viqbgrg.demo.easyexcel.chart;

import com.alibaba.excel.write.handler.RowWriteHandler;
import com.alibaba.excel.write.handler.context.RowWriteHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.xmlbeans.XmlBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.*;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;

/**
 * 自定义拦截器。对第一行第一列的头超链接到:https://github.com/alibaba/easyexcel
 *
 * @author Jiaju Zhuang
 */
@Slf4j
public class CustomCellWriteHandler implements RowWriteHandler {

    @Override
    public void beforeRowCreate(RowWriteHandlerContext context) {
        log.info("第{}行", context.getRowIndex());
        SXSSFSheet sheet = (SXSSFSheet) context.getWriteSheetHolder().getSheet();
        sheet.createDrawingPatriarch();
        // 创建一个画布
        XSSFDrawing drawing = sheet.getDrawingPatriarch();
        // 前四个默认0，开始列 开始行 结束列 结束行
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 1, 3, 15,25);
        // 创建一个chart对象
        XSSFChart chart =(XSSFChart) drawing.createChart(anchor);
        CTChart ctChart =chart.getCTChart();
        CTPlotArea ctPlotArea = ctChart.getPlotArea();
        //设置画布边框样式
        CTChartSpace space = chart.getCTChartSpace();
        space.addNewRoundedCorners().setVal(false);//去掉圆角
    }
}