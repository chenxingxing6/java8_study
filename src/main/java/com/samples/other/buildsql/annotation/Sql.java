package com.samples.other.buildsql.annotation;


import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Function;

/**
 * User: lanxinghua
 * Date: 2019/7/30 18:11
 * Desc:
 */
public class Sql {
    static Function<Object, String> objectToString = Object::toString;

    public static String query(Object object){
        Class mClass = object.getClass();
        boolean isExist = mClass.isAnnotationPresent(Table.class);
        if (!isExist){
            return null;
        }
        Table table = (Table)mClass.getAnnotation(Table.class);
        String tableName = table.value();
        Field[] fields = mClass.getDeclaredFields();

        // 拼装sql
        return buildSql(tableName, fields, mClass, object);
    }

    private static String buildSql(String tableName, Field[] fields, Class mclass, Object object){
        StringBuilder sb = new StringBuilder();
        sb.append("select * from ").append(tableName).append(" where 1=1");
        for (Field field : fields) {
            boolean isColumnExist = field.isAnnotationPresent(Column.class);
            if (!isColumnExist){
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            // 列名
            String columnName = column.value();
            // 获取字段值
            Object fieldValue = null;
            try {
                // 获取get方法
                PropertyDescriptor descriptor = new PropertyDescriptor(field.getName(), mclass);
                Method method = descriptor.getReadMethod();
                fieldValue = method.invoke(object);
                System.out.println("columnName:"+columnName  +"--columnValue:"+ fieldValue);
            }catch (Exception e){
                e.printStackTrace();
            }
            if (fieldValue == null){
                continue;
            }
            if (fieldValue instanceof Integer && ((Integer) fieldValue == 0)){
                continue;
            }
            sb.append(" and ").append(columnName);
            if (fieldValue instanceof String){
                // 含多个字段
                if (objectToString.apply(fieldValue).contains(",")){
                    String[] array = objectToString.apply(fieldValue).split(",");
                    sb.append(" in(");
                    Arrays.stream(array).forEach(r -> {
                        sb.append("'").append(r).append("'").append(",");
                    });
                    sb.deleteCharAt(sb.length() - 1).append(")");
                }else {
                    sb.append("=").append("'").append(fieldValue).append("'");
                }
            }
            else if (fieldValue instanceof Boolean){
                sb.append("=").append(fieldValue.equals(Boolean.TRUE) ? 1 : 0);
            }
            else if (fieldValue instanceof String){
                sb.append("=").append(fieldValue);
            }
            else{
                sb.append("=").append(fieldValue);
            }

        }
        return sb.toString();
    }
}
