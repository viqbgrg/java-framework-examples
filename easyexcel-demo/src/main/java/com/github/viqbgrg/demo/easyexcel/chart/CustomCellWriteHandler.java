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

        //设置图表位置
        //CTManualLayout manualLayout = chart.getManualLayout().getCTManualLayout();

        /*// 设置图表标题 setting chart title
        ((XSSFChart) chart).setTitleText("图表Demo");
        // 标题的位置（于图表上方或居中覆盖）
       ctChart.getTitle().addNewOverlay().setVal(false);
        ctChart.addNewShowDLblsOverMax().setVal(true);
        CTTitle tt  = ctChart.addNewTitle();
        ctChart.setTitle(tt);*/
        //设置标题方法2
        CTTitle ctTitle = ctChart.addNewTitle();
        ctTitle.addNewOverlay().setVal(false);// true时与饼图重叠
        ctTitle.addNewTx().addNewRich().addNewBodyPr();
        CTTextBody rich = ctTitle.getTx().getRich();
        rich.addNewLstStyle();
        CTRegularTextRun newR = rich.addNewP().addNewR();
        newR.setT(sheetName);  //标题名称
        newR.addNewRPr().setB(false);
        XmlBoolean xmlBoolean = XmlBoolean.Factory.newInstance();
        xmlBoolean.setBooleanValue(false);
        newR.getRPr().xsetB(xmlBoolean);//是否加粗 0不加粗 1加粗
        newR.getRPr().setLang("zh-CN");
        newR.getRPr().setAltLang("en-US");
        newR.getRPr().setSz(800);//字体大小
        newR.getRPr().addNewLatin().setTypeface("楷体");
        newR.getRPr().getLatin().setCharset((byte) -122);
        newR.getRPr().getLatin().setPitchFamily((byte)49);
        newR.getRPr().addNewEa().setTypeface("楷体");
        newR.getRPr().getEa().setCharset((byte) -122);
        newR.getRPr().getEa().setPitchFamily((byte)49);
        // 单元格没有数据时，该点在图表上为0或不显示或跳过直接连接
        ctChart.addNewDispBlanksAs().setVal(STDispBlanksAs.SPAN);
        //是否添加左侧坐标轴
        ctChart.addNewShowDLblsOverMax().setVal(true);
        // 折线图
        CTLineChart ctLineChart = ctPlotArea.addNewLineChart();
//        CTLineChart ctLineChart2 = ctPlotArea.addNewLineChart();
        CTBoolean ctBoolean = ctLineChart.addNewVaryColors();
        ctLineChart.addNewGrouping().setVal(STGrouping.STANDARD);
        // 创建序列,并且设置选中区域
        for (int i = 1; i < dataList.size() ; i++) {
            CTLineSer ctLineSer = ctLineChart.addNewSer();

            CTSerTx ctSerTx = ctLineSer.addNewTx();
            // 图例区
            CTStrRef ctStrRef = ctSerTx.addNewStrRef();
            String legendDataRange = new CellRangeAddress( i, i, 0, 0).formatAsString(sheetName, true);
            ctStrRef.setF(legendDataRange);
            ctLineSer.addNewIdx().setVal(i);
            // 横坐标区
            CTAxDataSource cttAxDataSource = ctLineSer.addNewCat();
            ctStrRef = cttAxDataSource.addNewStrRef();
            String axisDataRange = new CellRangeAddress(0, 0, 1, titleArr.size()).formatAsString(sheetName, true);
            ctStrRef.setF(axisDataRange);
            // 数据区域
            CTNumDataSource ctNumDataSource = ctLineSer.addNewVal();
            CTNumRef ctNumRef = ctNumDataSource.addNewNumRef();
            // 选第1-6行,第1-3列作为数据区域 //1 2 3
            //23456
            String numDataRange = new CellRangeAddress(i,i , 2,6).formatAsString(sheetName, true);
            System.out.println(numDataRange);
            ctNumRef.setF(numDataRange);
            // 设置标签格式
            ctBoolean.setVal(false);
            CTDLbls newDLbls = ctLineSer.addNewDLbls();
            newDLbls.setShowLegendKey(ctBoolean);
            ctBoolean.setVal(true);
            newDLbls.setShowVal(ctBoolean);
            ctBoolean.setVal(false);
            newDLbls.setShowCatName(ctBoolean);
            newDLbls.setShowSerName(ctBoolean);
            newDLbls.setShowPercent(ctBoolean);
            newDLbls.setShowBubbleSize(ctBoolean);
            newDLbls.setShowLeaderLines(ctBoolean);

            // 是否是平滑曲线
            CTBoolean addNewSmooth = ctLineSer.addNewSmooth();
            addNewSmooth.setVal(false);
            // 是否是堆积曲线?
            CTMarker addNewMarker = ctLineSer.addNewMarker();
            CTMarkerStyle markerStyle = addNewMarker.addNewSymbol();
            //NONE-无 CIRCLE-实心圆圈 STAR-星号  DASH-实线 DIAMOND-方块（菱形） DOT-点 PLUS-加号 SQUARE-正方形 TRIANGLE-三角形 X-X
            markerStyle.setVal(STMarkerStyle.CIRCLE);
            //设置线条颜色
            STHexBinary3 hex = STHexBinary3.Factory.newInstance();
            hex.setStringValue("5555FF");
            CTShapeProperties ctShapeProperties = ctLineSer.addNewSpPr();
            CTLineProperties lineProperties = ctShapeProperties.addNewLn();
            CTSolidColorFillProperties properties = lineProperties.addNewSolidFill();
            CTSRgbColor rgbColor = properties.addNewSrgbClr();
            rgbColor .xsetVal(hex);
            //设置线条粗细
            lineProperties.setW(20000);
            //设置线条类型 虚线 实线
            CTPresetLineDashProperties ctPresetLineDashProperties = lineProperties.addNewPrstDash();
            ctPresetLineDashProperties.setVal(STPresetLineDashVal.LG_DASH);

        }


        //告诉条形图它有轴并给它们ID

        int xAxisId = dataList.size() + 1 + 10000;
        int yAxisId = dataList.size() + 2 + 10000;
        ctLineChart.addNewAxId().setVal(xAxisId);
        ctLineChart.addNewAxId().setVal(yAxisId);
        //==========================================
        // 设置x轴属性
        Boolean isXAxisDelete =false ;
        CTCatAx ctCatAx = ctPlotArea.addNewCatAx();
        ctCatAx.addNewAxId().setVal(xAxisId);
        ctCatAx.addNewCrossAx().setVal(yAxisId);
        CTScaling ctScaling = ctCatAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);  //X轴排列方向
        ctCatAx.addNewDelete().setVal(isXAxisDelete);// 是否隐藏x轴
        ctCatAx.addNewAxPos().setVal(STAxPos.B);// x轴位置（左右上下）
        ctCatAx.addNewMajorTickMark().setVal(STTickMark.OUT);// 主刻度线在轴上的位置（内、外、交叉、无）
        ctCatAx.addNewMinorTickMark().setVal(STTickMark.NONE);// 次刻度线在轴上的位置（内、外、交叉、无）
        ctCatAx.addNewAuto().setVal(true);
        ctCatAx.addNewLblAlgn().setVal(STLblAlgn.CTR);
        ctCatAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);// 标签（即刻度文字）的位置（轴旁、高、低、无）
        ctCatAx.addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().setVal( new XSSFColor(new Color(58, 76, 78)).getRGB());// x轴颜色,有两种方式设置颜色
//        STHexBinary3 hex_x = STHexBinary3.Factory.newInstance();
//        hex_x.setStringValue("5555FF");
//        ctCatAx.addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().xsetVal(hex_x);
//         ctCatAx.addNewCrosses().setVal(STCrosses.MIN);   //X轴以Y轴的最小值或最大值穿过Y轴
    }
}