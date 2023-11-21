package com.github.viqbgrg.demo.thymeleaf;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.util.ObjectUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @Author: hewk
 * @Date: 2021/9/13 20:18
 */
public class TemplateConvertUtil {

    private static String STATIC_TEMPLATE_SUFFIX = ".html";


    /**
     * 装载模板数据生成html，并将其转换为字符串输出
     * @return
     */
    public static String loadingTemplateAndConvertToString(Map<String,Object> param, String templateName){
        String result = null;

            ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
            resolver.setSuffix(STATIC_TEMPLATE_SUFFIX);//模板文件后缀
            TemplateEngine templateEngine = new TemplateEngine();
            templateEngine.setTemplateResolver(resolver);

            Context context = new Context();

            if(param == null || param.isEmpty()){
                return result;
            }

            // 装载数据
            param.forEach((key,value) -> {
                context.setVariable(key,value);
            });
            // 将数据装进模板生成新的HTML
            StringWriter stringWriter = new StringWriter();
        String process = templateEngine.process(templateName, context);

        return process;
    }

    public static String toHtmlString(File file) {
        // 获取HTML文件流
        StringBuffer htmlSb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), "utf-8"));
            while (br.ready()) {
                htmlSb.append(br.readLine());
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // HTML文件字符串
        String htmlStr = htmlSb.toString();
        // 返回经过清洁的html文本
        return htmlStr;
    }

}
