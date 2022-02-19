package com.viqbgrg.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.ISqlSegment;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.conditions.segments.NormalSegmentList;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.viqbgrg.mybatisplus.entity.Book;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author hhj
 */
@MybatisPlusTest
public class WrapperTest {
    @Test
    void wrapperTest() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        LambdaUpdateWrapper<Book> in = Wrappers.lambdaUpdate(Book.class).eq(Book::getId, "1").in(Book::getName, strings);
        System.out.println(in.getSqlSegment());
        MergeSegments expression = in.getExpression();
        NormalSegmentList normal = expression.getNormal();
        for (int i = 0; i < normal.size(); i++) {
            ISqlSegment iSqlSegment = normal.get(i);
            String sqlSegment = iSqlSegment.getSqlSegment();
            System.out.println(sqlSegment);
        }
        System.out.println(expression);
    }
}
