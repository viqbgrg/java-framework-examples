package com.github.viqbgrg.plugins.mybatis;

import com.github.viqbgrg.plugins.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.Join;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SubSelect;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.util.Properties;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

/**
 * @author hhj
 */
@Intercepts({@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class}),

        @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class,Integer.class }),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
@Slf4j
public class ExamplePlugin implements Interceptor {
    private Properties properties = new Properties();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if(invocation.getTarget() instanceof RoutingStatementHandler) {
            RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
            StatementHandler delegate = (StatementHandler) ReflectUtil.getFieldValue(handler, "delegate");
            //通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
            MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getFieldValue(delegate, "mappedStatement");
            //千万不能用下面注释的这个方法，会造成对象丢失，以致转换失败
            //MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];

//            String permissionAop = null;
//            if(permissionAop == null){
//                if(log.isInfoEnabled()){
//                    log.info("数据权限放行...");
//                }
//                return invocation.proceed();
//            }
            if(log.isInfoEnabled()){
                log.info("数据权限处理【拼接SQL】...");
            }
            BoundSql boundSql = delegate.getBoundSql();
            //Connection connection = (Connection) invocation.getArgs()[0];
            ReflectUtil.setFieldValue(boundSql, "sql", processSelectSql(boundSql.getSql()));
        }
        return invocation.proceed();
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }


    private String processSelectSql(String sql) {
        try {
            String replaceSql = null;
            Select select = (Select) CCJSqlParserUtil.parse(sql);
            PlainSelect selectBody = (PlainSelect) select.getSelectBody();
            String mainTable = null;
            if (selectBody.getFromItem() instanceof Table) {
                mainTable = ((Table) selectBody.getFromItem()).getName().replace("`", "");
            } else if (selectBody.getFromItem() instanceof SubSelect) {
                replaceSql = processSelectSql(((SubSelect) selectBody.getFromItem()).getSelectBody().toString());
            }
            if (replaceSql != null && replaceSql != "") {
                sql = sql.replace(((Table) selectBody.getFromItem()).getName(), replaceSql);
            }
            String mainTableAlias = mainTable;
            try {
                mainTableAlias = selectBody.getFromItem().getAlias().getName();
            } catch (Exception e) {
                log.debug("当前sql中， " + mainTable + " 没有设置别名");
            }


            String condExpr = null;


            if (sql.indexOf("limit ?,?") != -1 && select.toString().indexOf("LIMIT ? OFFSET ?") != -1) {
                sql = select.toString().replace("LIMIT ? OFFSET ?", "limit ?,?");
            } else {
                sql = select.toString();
            }

        } catch (JSQLParserException e) {
            log.error("change sql error .", e);
        }
        return sql;
    }
}
