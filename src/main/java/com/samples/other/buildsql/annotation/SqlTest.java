package com.samples.other.buildsql.annotation;

import com.samples.other.buildsql.Floor;

/**
 * User: lanxinghua
 * Date: 2019/7/30 18:19
 * Desc: 动态拼装sql
 */
public class SqlTest {
    public static void main(String[] args) {
        Floor s1 = Floor.builder().buildingId("351736414771216384,351736414787960832").isValid(Boolean.TRUE).build();
        String sql = Sql.query(s1);
        System.out.println(sql);
    }
}


