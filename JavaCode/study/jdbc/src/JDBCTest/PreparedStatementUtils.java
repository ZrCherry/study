package JDBCTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: PreparedStatementUtils
 * Package: JDBCTest
 * Description:
 * 使用PreparedStatement操作数据库的通用接口
 * @Author cherry
 * @Create 2023/8/2 11:10
 * @Version 1.0
 */
public class PreparedStatementUtils {

    /**
     * 通用的增删改操作接口
     * @param sql
     * @param args
     */
    public void update(String sql,Object ...args){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtils.getConection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,ps);
        }
    }
    /*
     * 通用的增删改操作接口。
     * 考虑事务的接口，将connection作为参数传进来。
     * */
    public void update(Connection connection,String sql,Object ...args){
        PreparedStatement ps = null;
        try {
            connection = JDBCUtils.getConection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,ps);
        }
    }

    /**
     * 通用的查询接口
     */
    public <T> List<T> query(Class<T> clazz, String sql, Object ...args) {
        PreparedStatement ps = null;
        Connection conection = null;
        ResultSet rs = null;
        ArrayList<T> list = new ArrayList<>();
        try {
            conection = JDBCUtils.getConection();
            ps = conection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            //获取元数据，
            ResultSetMetaData metaData = rs.getMetaData();
            //通过元数据获取查询到的列数
            int count = metaData.getColumnCount();
            while (rs.next()){
                Constructor<T> constructor = clazz.getDeclaredConstructor();
                T t = constructor.newInstance();
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
        } finally {
            JDBCUtils.close(conection,ps,rs);
        }
        return list;
    }
}
