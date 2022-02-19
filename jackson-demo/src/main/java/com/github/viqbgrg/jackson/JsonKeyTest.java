package com.github.viqbgrg.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * json key 获取
 * @author hhj
 */
public class JsonKeyTest {
    @Test
    void test1() throws JsonProcessingException {
        String s = "{\n" +
                "    \"design\": {\n" +
                "        \"paramProductStoreId\": \"STORE_10041\",\n" +
                "        \"yunDesignUserId\": \"UFefbk1wji7W57WZJbBF\",\n" +
                "        \"operatorDasebaseToken\": \"\",\n" +
                "        \"productId\": \"d4BDB4F63FC17A8A3B15\",\n" +
                "        \"productName\": \"设计方案20210826140522\",\n" +
                "        \"productVersion\": \"0.0\",\n" +
                "        \"jobIdString\": \"[]\",\n" +
                "        \"parentProductId\": \"\",\n" +
                "        \"customerAddress\": \"\",\n" +
                "        \"crmServiceNumber\": \"\",\n" +
                "        \"crmServiceNumberType\": \"\",\n" +
                "        \"oneKicOrderType\": \"\",\n" +
                "        \"recordPrice\": \"\",\n" +
                "        \"channelSaleOrderCustomerId\": \"\",\n" +
                "        \"productPrice\": 0,\n" +
                "        \"productBrandDesc\": \"[]\",\n" +
                "        \"productDesignBrands\": \"\",\n" +
                "        \"colorCard\": \"{}\",\n" +
                "        \"productMeasureArea\": \"\",\n" +
                "        \"oneKicDesign\": \"0\",\n" +
                "        \"originalProductId\": \"\",\n" +
                "        \"productSubType\": \"\",\n" +
                "        \"designRoom\": \"0\",\n" +
                "        \"designHall\": \"0\",\n" +
                "        \"designBathroom\": \"0\",\n" +
                "        \"productStyleId\": \"\",\n" +
                "        \"provinceId\": \"\",\n" +
                "        \"cityId\": \"\",\n" +
                "        \"areaId\": \"\",\n" +
                "        \"villageName\": \"\",\n" +
                "        \"designProjectId\": \"JbPDDT8kLmQEKstV0iDO\",\n" +
                "        \"iconDomainNum\": 0\n" +
                "    },\n" +
                "    \"productListData\": {\n" +
                "        \"projectId\": \"\",\n" +
                "        \"projectName\": \"项目报价汇总表\",\n" +
                "        \"designId\": \"\",\n" +
                "        \"designName\": \"\",\n" +
                "        \"designAddress\": \"\",\n" +
                "        \"designProducer\": \"\",\n" +
                "        \"designDate\": \"\",\n" +
                "        \"designMasterId\": \"admin\",\n" +
                "        \"designMasterName\": \"adminName\",\n" +
                "        \"customerName\": \"\",\n" +
                "        \"customerPhone\": \"\",\n" +
                "        \"companyName\": \"上海荟画家信息科技有限公司\",\n" +
                "        \"brandLogo\": \"https://floorplan-designer-bucket.oss-cn-hangzhou.aliyuncs.com/filesystem/assets/logo/hzn.svg\",\n" +
                "        \"config\": {\n" +
                "            \"systemSelect\": {},\n" +
                "            \"labelSelect\": {}\n" +
                "        },\n" +
                "        \"systemList\": [],\n" +
                "        \"paramsSystemDisCount\": \"{}\",\n" +
                "        \"serviceList\": [{\n" +
                "            \"serviceId\": \"total\",\n" +
                "            \"serviceName\": \"\",\n" +
                "            \"serviceRemark\": \"\",\n" +
                "            \"totalPrice\": 0\n" +
                "        }],\n" +
                "        \"paramsOtherPirceList\": \"[]\",\n" +
                "        \"productList\": []\n" +
                "    }\n" +
                "}";
        desMap(s);
    }

    HashMap<String, Object> desMap(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<HashMap<String, Object>> typeRef
                = new TypeReference<HashMap<String, Object>>() {};
        HashMap<String, Object> stringStringHashMap = objectMapper.readValue(json, typeRef);
        return stringStringHashMap;
    }
}
