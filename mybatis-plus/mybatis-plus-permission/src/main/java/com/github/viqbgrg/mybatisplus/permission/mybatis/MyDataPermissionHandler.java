package com.github.viqbgrg.mybatisplus.permission.mybatis;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.handler.MultiDataPermissionHandler;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.Parenthesis;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.expression.operators.relational.ItemsList;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;

public class MyDataPermissionHandler implements MultiDataPermissionHandler {

    @Override
    public Expression getSqlSegment(Table table, Expression where, String mappedStatementId) {
        InExpression inExpression = new InExpression();
        inExpression.setLeftExpression(new Column("class_id"));
        ItemsList itemsList = new ExpressionList(new LongValue(2));
        inExpression.setRightItemsList(itemsList);
        return ObjectUtils.isNotEmpty(where) ? new AndExpression(where, new Parenthesis(inExpression)) : new Parenthesis(inExpression);
    }
}
