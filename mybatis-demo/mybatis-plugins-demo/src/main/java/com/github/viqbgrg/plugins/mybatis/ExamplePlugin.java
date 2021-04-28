package com.github.viqbgrg.plugins.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @author hhj
 */
@Intercepts({@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
@Slf4j
public class ExamplePlugin implements Interceptor {
    private Properties properties = new Properties();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // implement pre processing if need
        if (invocation.getTarget() instanceof RoutingStatementHandler) {
            RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
//            StatementHandler delegate = (StatementHandler) ReflectUtil.getFieldValue(handler, "delegate");
            //通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
//            MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getFieldValue(delegate, "mappedStatement");
            //千万不能用下面注释的这个方法，会造成对象丢失，以致转换失败
            //MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
//            PermissionAop permissionAop = PermissionUtils.getPermissionByDelegate(mappedStatement);
//            if(permissionAop == null){
//                if(log.isInfoEnabled()){
//                    log.info("数据权限放行...");
//                }
//                return invocation.proceed();
//            }
            if (log.isInfoEnabled()) {
                log.info("数据权限处理【拼接SQL】...");
            }
//            BoundSql boundSql = delegate.getBoundSql();
//            ReflectUtil.setFieldValue(boundSql, "sql", boundSql.getSql());
        }
        Object returnObject = invocation.proceed();
        // implement post processing if need
        return returnObject;
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }


    private String processSelectSql(String sql) {
//        try {
//            String replaceSql = null;
//            Select select = (Select) CCJSqlParserUtil.parse(sql);
//            PlainSelect selectBody = (PlainSelect) select.getSelectBody();
//            String mainTable = null;
//            if (selectBody.getFromItem() instanceof Table) {
//                mainTable = ((Table) selectBody.getFromItem()).getName().replace("`", "");
//            } else if (selectBody.getFromItem() instanceof SubSelect) {
//                replaceSql = processSelectSql(((SubSelect) selectBody.getFromItem()).getSelectBody().toString(), rules, user);
//            }
//            if (replaceSql != null || replaceSql != "") {
//                sql = sql.replace(((SubSelect) selectBody.getFromItem()).getSelectBody().toString(), replaceSql);
//            }
//            String mainTableAlias = mainTable;
//            try {
//                mainTableAlias = selectBody.getFromItem().getAlias().getName();
//            } catch (Exception e) {
//                log.debug("当前sql中， " + mainTable + " 没有设置别名");
//            }
//
//
//            String condExpr = null;
//            Roles realRuls = null;
//            for (Roles rule: rules) {
//                for (Object roleStr :
//                        user.getRoles()) {
//                    if (rule.getRoles().indexOf("," + roleStr + ",") != -1) {
//                        if (rule.getFromEntity().indexOf("," + mainTable + ",") != -1) {
//                            // 若主表匹配规则主体，则直接使用本规则
//                            realRuls = rule;
//
//                            condExpr = rule.getExps().replace("{uid}", UserDefaultUtil.getUserId().toString()).replace("{bid}", UserDefaultUtil.getBusinessId().toString()).replace("{me}", mainTable).replace("{me.a}", mainTableAlias);
//                            if (selectBody.getWhere() == null) {
//                                selectBody.setWhere(CCJSqlParserUtil.parseCondExpression(condExpr));
//                            } else {
//                                AndExpression and = new AndExpression(selectBody.getWhere(), CCJSqlParserUtil.parseCondExpression(condExpr));
//                                selectBody.setWhere(and);
//                            }
//                        }
//
//                        try {
//                            String joinTable = null;
//                            String joinTableAlias = null;
//                            for (Join j :
//                                    selectBody.getJoins()) {
//                                if (rule.getFromEntity().indexOf("," + ((Table) j.getRightItem()).getName() + ",") != -1) {
//                                    // 当主表不能匹配时，匹配所有join，使用符合条件的第一个表的规则。
//                                    realRuls = rule;
//                                    joinTable = ((Table) j.getRightItem()).getName();
//                                    joinTableAlias = j.getRightItem().getAlias().getName();
//
//                                    condExpr = rule.getExps().replace("{uid}", UserDefaultUtil.getUserId().toString()).replace("{bid}", UserDefaultUtil.getBusinessId().toString()).replace("{me}", joinTable).replace("{me.a}", joinTableAlias);
//                                    if (j.getOnExpression() == null) {
//                                        j.setOnExpression(CCJSqlParserUtil.parseCondExpression(condExpr));
//                                    } else {
//                                        AndExpression and = new AndExpression(j.getOnExpression(), CCJSqlParserUtil.parseCondExpression(condExpr));
//                                        j.setOnExpression(and);
//                                    }
//                                }
//                            }
//                        } catch (Exception e) {
//                            log.debug("当前sql没有join的部分！");
//                        }
//                    }
//                }
//            }
//            if (realRuls == null) return sql; // 没有合适规则直接退出。
//
//            if (sql.indexOf("limit ?,?") != -1 && select.toString().indexOf("LIMIT ? OFFSET ?") != -1) {
//                sql = select.toString().replace("LIMIT ? OFFSET ?", "limit ?,?");
//            } else {
//                sql = select.toString();
//            }
//
//        } catch (JSQLParserException e) {
//            log.error("change sql error .", e);
//        }
        return sql;
    }
}
