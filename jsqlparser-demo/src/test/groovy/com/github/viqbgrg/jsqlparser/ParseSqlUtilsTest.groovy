package com.github.viqbgrg.jsqlparser

import net.sf.jsqlparser.parser.CCJSqlParserUtil
import spock.lang.Specification

class ParseSqlUtilsTest extends Specification {
    def "test getTableName"() {
        def utils = new ParseSqlUtils()
        def sql = "select * from p"
        expect:
            utils.getTableName(sql) == "p"
    }

    def "aiot"() {
        def sql = "select distinct a.id,a.sequence,a.specification,a.sku_id,a.thumbnail,a.retail_price,a.cost_price,a.inventory,a.type,a.goods_id,a.model_id,\n" +
                "         \n" +
                "                a.status,\n" +
                "             \n" +
                "         \n" +
                "        b.id as pb_id, b.company_id as pb_company_id, b.shop_id as pb_shop_id,b.goods_name as pb_goods_name, b.images as pb_images, b.videos as pb_videos, b.port_data as pb_port_data, b.buy_link as pb_buy_link, b.protocol_platform_id as pb_protocol_platform_id, b.goods_type as pb_goods_type, b.specification_list as pb_specification_list, b.attribute_information as pb_attribute_information, b.is_show as pb_is_show, b.status as pb_status, b.flag as pb_flag, b.create_time as pb_create_time, b.create_user_id as pb_create_user_id, b.update_user_id as pb_update_user_id, b.update_time as pb_update_time, b.goods_intro as pb_goods_intro, b.installation_parameter as pb_installation_parameter, b.acceptance_standard as pb_acceptance_standard, b.ibdn as pb_ibdn, b.goods_details as pb_goods_details, b.data_sequence as pb_data_sequence, b.product_ascription_type as pb_product_ascription_type, b.sequence as pb_sequence, b.specification as pb_specification, b.parent_id as pb_parent_id,  b.goods_id as pb_goods_id, b.sku_id as pb_sku_id, b.thumbnail as pb_thumbnail, b.cost_price as pb_cost_price, b.retail_price as pb_retail_price, b.inventory as pb_inventory, b.type as pb_type, b.model_id as pb_model_id\n" +
                "     \n" +
                "        from product_goods a left join product_goods b on a.goods_id = b.id\n" +
                "        left join product_category as category on a.goods_id = category.goods_id\n" +
                "        left join product_category as enterprise on a.goods_id = enterprise.goods_id\n" +
                "         \n" +
                "        where a.goods_type = 'SKU'  and a.flag <> 1 \n" +
                "\n" +
                "         \n" +
                "         \n" +
                "\n" +
                "         \n" +
                "         \n" +
                "         \n" +
                "         \n" +
                "         \n" +
                "         \n" +
                "         \n" +
                "         \n" +
                "         \n" +
                "                    and b.product_ascription_type = ?\n" +
                "             \n" +
                "        order by b.create_time desc LIMIT ?"
        expect:
            CCJSqlParserUtil.parse(sql);
    }

    def "子查询"(){
        def sql = 'SELECT (SELECT COUNT(product_id) FROM design_info WHERE product_removed = \'N\'\n' +
                '            ) AS designNum,\n' +
                '               (SELECT COUNT(id) FROM design_project WHERE flag = 0\n' +
                '        ) AS projectNum, (SELECT COALESCE(SUM(product_price),0.00) FROM design_info WHERE product_removed = \'N\' AND product_status = \'SETTLED\' ) AS totalProductPrice'
//        def sqlResult = 'SELECT (SELECT COUNT(product_id) FROM design_info WHERE product_removed = \'N\' and a.b = \'1\'\n' +
//                '            ) AS designNum,\n' +
//                '               (SELECT COUNT(id) FROM design_project WHERE flag = 0\n' +
//                '        ) AS projectNum, (SELECT COALESCE(SUM(product_price),0.00) FROM design_info WHERE product_removed = \'N\' AND product_status = \'SETTLED\' ) AS totalProductPrice'
        def sqlResult = 'SELECT (SELECT COUNT(product_id) FROM design_info WHERE product_removed = \'N\' AND a.b = \'1\') AS designNum, (SELECT COUNT(id) FROM design_project WHERE flag = 0 AND a.b = \'1\') AS projectNum, (SELECT COALESCE(SUM(product_price), 0.00) FROM design_info WHERE product_removed = \'N\' AND product_status = \'SETTLED\' AND a.b = \'1\') AS totalProductPrice'
        expect:
        sqlResult == ParseSqlUtils.addWhere(sql)
    }

}
