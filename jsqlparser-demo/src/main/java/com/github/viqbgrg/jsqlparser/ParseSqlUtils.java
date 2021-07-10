package com.github.viqbgrg.jsqlparser;

import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SubSelect;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.util.List;

/**
 * @author hhj
 */
@Slf4j
public class ParseSqlUtils {
    public String getTableName(String sql) throws JSQLParserException {
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
}
