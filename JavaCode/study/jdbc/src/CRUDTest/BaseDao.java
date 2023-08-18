package CRUDTest;

import JDBCTest.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: BaseDao
 * Package: CRUDTest
 * Description:
 *
 * @Author cherry
 * @Create 2023/8/2 16:06
 * @Version 1.0
 */
public abstract class BaseDao<T> {

    private Class<T> clazz;
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType type = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = type.getActualTypeArguments();
        clazz = (Class) actualTypeArguments[0];
    }


    //通用的增删改方法
    public int update(Connection conn,String sql,Object ...args){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(null,ps);
        }
        return 0;
    }

    public List<T> getInstance(Connection conn,String sql,Object ...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int count = metaData.getColumnCount();
            while (rs.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < count; i++) {
                    //通过反射获取指定列的属性，然后赋值。这里就需要属性名和数据库中的属性名称一一映射。
                    Object value = rs.getObject(i + 1);
                    //通过ResultSetMetaData
                    //获取列的列名：getColumnName  不推介使用
                    //获取列的别名：getColumnLabel 没有别名，获取的就是列名。
                    //String columnName = metaData.getColumnName(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,value);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,ps,rs);
        }
        return list;
    }

    //用于查询特殊值的通用方法
    public  <E> E getValue(Connection conn,String sql,Object ...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            while (rs.next()){
                return (E) rs.getObject(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(null,ps,rs);
        }
        return null;
    }
}
