package com.github.viqbgrg.jsqlparser;

import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hhj
 */
@Slf4j
public class ParseSqlUtils {
    public static String getTableName(String sql) throws JSQLParserException {
        String replaceSql = null;
        Statement statement = CCJSqlParserUtil.parse(sql);
        Select select = (Select) statement;
        PlainSelect selectBody = (PlainSelect) select.getSelectBody();
        String mainTable = null;
        if (selectBody.getFromItem() instanceof Table) {
            mainTable = ((Table) selectBody.getFromItem()).getName().replace("`", "");
        } else if (selectBody.getFromItem() instanceof SubSelect) {

        }
        String mainTableAlias = mainTable;
        try {
            mainTableAlias = selectBody.getFromItem().getAlias().getName();
        } catch (Exception e) {
            log.debug("当前sql中， " + mainTable + " 没有设置别名");
        }
        return mainTable;
    }

    public static String addWhere(String sql) throws JSQLParserException {
        String replaceSql = null;
        Statement parse = CCJSqlParserUtil.parse(sql);
        if (!(parse instanceof Select)) {
            return sql;
        }
        Select select = (Select)parse;
        PlainSelect selectBody = (PlainSelect) select.getSelectBody();
        String mainTable = null;
        if (selectBody.getFromItem() instanceof Table) {
            mainTable = ((Table) selectBody.getFromItem()).getName().replace("`", "");
        } else if (selectBody.getFromItem() instanceof SubSelect) {
            replaceSql = addWhere(((SubSelect) selectBody.getFromItem()).getSelectBody().toString());
        } else if (selectBody.getSelectItems().size() > 0) {
            Map<String, String> replaceMap = new HashMap<>();
            for (int i = 0; i < selectBody.getSelectItems().size(); i++) {
                SelectItem selectItem = selectBody.getSelectItems().get(i);
                if (selectItem instanceof SelectExpressionItem) {
                    Expression expression = ((SelectExpressionItem) selectItem).getExpression();
                    if (expression instanceof SubSelect) {
                        String s = ((SubSelect) expression).getSelectBody().toString();
                        String resultSql = addWhere(s);
                        replaceMap.put(s, resultSql);
                    }
                }
            }
            for (String key : replaceMap.keySet()) {
                String value = replaceMap.get(key);
                sql = sql.replace(key, value);
            }
        }
        if (selectBody.getFromItem() != null && replaceSql != null && replaceSql != "") {
            sql = sql.replace(((Table) selectBody.getFromItem()).getName(), replaceSql);
        }


        String condExpr = "a.b = '1'";

        log.info("增加的sql: {}", condExpr);
        if (selectBody.getWhere() == null) {
            selectBody.setWhere(CCJSqlParserUtil.parseCondExpression(condExpr));
        } else {
            AndExpression and = new AndExpression(selectBody.getWhere(), CCJSqlParserUtil.parseCondExpression(condExpr));
            selectBody.setWhere(and);
        }

        if (sql.indexOf("limit ?,?") != -1 && select.toString().indexOf("LIMIT ? OFFSET ?") != -1) {
            sql = select.toString().replace("LIMIT ? OFFSET ?", "limit ?,?");
        } else {
            sql = select.toString();
        }
        return sql;
    }
}
