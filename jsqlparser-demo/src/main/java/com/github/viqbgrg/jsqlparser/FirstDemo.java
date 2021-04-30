package com.github.viqbgrg.jsqlparser;

import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.util.SelectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hhj
 */
@Slf4j
public class FirstDemo {


    /**
     * 先解析简单的sql
     */
    public void parser() throws JSQLParserException {
        String sql = "select * from user where user_id = 1";
        log.info(sql);
        Statement statement = CCJSqlParserUtil.parse(sql);
        if (statement instanceof Select) {
            Select selectStatement = (Select) statement;
            PlainSelect selectBody = (PlainSelect)selectStatement.getSelectBody();
            Table table = (Table)selectBody.getFromItem();
            String tableName = table.getName();
            log.info(tableName);
        }
    }

    public String build(String oldSql) throws JSQLParserException {
        Statement statement = CCJSqlParserUtil.parse(oldSql);
        Select select1 = (Select)statement;
        SelectBody selectBody = select1.getSelectBody();
        SubSelect subSelect = new SubSelect();
        subSelect.setSelectBody(selectBody);


//        Select select = SelectUtils.buildSelectFromTableAndExpressions(new Table("mytable"), "a+b", "test");
        Select select = SelectUtils.buildSelectFromTable(new SubSelect(oldSql));
        return null;
    }
}
