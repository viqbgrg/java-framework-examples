package com.github.viqbgrg.mybatisplus.injectordemo;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.github.viqbgrg.mybatisplus.injectordemo.methods.MysqlInsertQueryBatch;

import java.util.List;

/**
 * 自定义 SqlInjector
 *
 * @author miemie
 * @since 2018-08-13
 */
public class MyLogicSqlInjector extends DefaultSqlInjector {

    /**
     * 如果只需增加方法，保留MP自带方法
     * 可以super.getMethodList() 再add
     *
     * @return
     */
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        methodList.add(new MysqlInsertQueryBatch());
        return methodList;
    }
}
