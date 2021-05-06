package com.github.viqbgrg.jsqlparser;

import checkers.units.quals.A;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.util.SelectUtils;
import net.sf.jsqlparser.util.deparser.ExpressionDeParser;
import net.sf.jsqlparser.util.deparser.SelectDeParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author hhj
 */
@Slf4j
public class FirstDemo {


    /**
     * 先解析简单的sql
     */
    public void parser() throws JSQLParserException {
        String sql = "select a,b from user where user_id = 1";
        log.info(sql);
        Statement statement = CCJSqlParserUtil.parse(sql);
        if (statement instanceof Select) {
            Select selectStatement = (Select) statement;
            PlainSelect selectBody = (PlainSelect)selectStatement.getSelectBody();
            Table table = (Table)selectBody.getFromItem();
            String tableName = table.getName();
            log.info(tableName);
            List<SelectItem> selectItems = selectBody.getSelectItems();
            selectItems.forEach(System.out::println);
        }
    }

    public String build(String oldSql) throws JSQLParserException {
        Statement statement = CCJSqlParserUtil.parse("select * from (" + oldSql + ") as a");
        if (statement instanceof Select) {
            Select selectStatement = (Select) statement;
            PlainSelect plainSelect = (PlainSelect) selectStatement.getSelectBody();
            Expression where = plainSelect.getWhere();
            EqualsTo equalsTo = new EqualsTo();
            equalsTo.setLeftExpression(new Column("a.name"));
            equalsTo.setRightExpression(new StringValue("'张三'"));
            if (where == null) {
                plainSelect.setWhere(equalsTo);
            } else {
                // 用and链接条件
                AndExpression and = new AndExpression(where, equalsTo);
                // 设置新的where条件
                plainSelect.setWhere(and);
            }
        }
        System.out.println(statement.toString());
        return statement.toString();
    }
}
