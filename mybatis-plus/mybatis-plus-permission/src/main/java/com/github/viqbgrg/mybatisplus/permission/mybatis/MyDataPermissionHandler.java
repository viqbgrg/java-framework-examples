package com.github.viqbgrg.mybatisplus.permission.mybatis;

import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.handler.MultiDataPermissionHandler;
import com.github.viqbgrg.mybatisplus.permission.PermissionType;
import com.github.viqbgrg.mybatisplus.permission.annotation.Permission;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.Parenthesis;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.expression.operators.relational.ItemsList;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyDataPermissionHandler implements MultiDataPermissionHandler {

    private static final Map<String, HashMap<PermissionType, String>> PERMISSION_INFO_CACHE = new ConcurrentHashMap<>();

    @Override
    public Expression getSqlSegment(Table table, Expression where, String mappedStatementId) {
        String tableName = table.getName();
        TableInfo tableInfo = TableInfoHelper.getTableInfo(tableName);
        HashMap<PermissionType, String> result = null;
        if (PERMISSION_INFO_CACHE.containsKey(tableName)) {
            result = PERMISSION_INFO_CACHE.get(tableName);
        } else {
            result = new HashMap<>();
            String keyProperty = tableInfo.getKeyProperty();
            try {
                Permission annotation = tableInfo.getKeyType().getDeclaredField(keyProperty).getAnnotation(Permission.class);
                if (annotation != null) {
                    PermissionType value = annotation.value();
                    result.put(value, tableInfo.getKeyColumn());
                }
            } catch (NoSuchFieldException e) {

            }
            List<TableFieldInfo> fieldList = tableInfo.getFieldList();
            for (TableFieldInfo tableFieldInfo : fieldList) {
                Field field = tableFieldInfo.getField();
                Permission annotation = null;
                annotation = field.getAnnotation(Permission.class);
                if (annotation != null) {
                    PermissionType value = annotation.value();
                    result.put(value, tableFieldInfo.getColumn());
                }
            }
            PERMISSION_INFO_CACHE.put(tableName, result);
        }
        String s = result.get(PermissionType.GRADE);
        if (!StringUtils.hasText(s)) {
            return null;
        }
        InExpression inExpression = new InExpression();
        Alias alias = table.getAlias();
        if (alias != null) {
            s = alias.getName() + "." + s;
        }
        inExpression.setLeftExpression(new Column(s));
        ItemsList itemsList = new ExpressionList(new LongValue(2));
        inExpression.setRightItemsList(itemsList);
        return ObjectUtils.isNotEmpty(where) ? new AndExpression(where, new Parenthesis(inExpression)) : where;
    }
}
