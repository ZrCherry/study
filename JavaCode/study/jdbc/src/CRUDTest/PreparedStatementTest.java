package CRUDTest;

import JDBCTest.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: PreparedStatementTest
 * Package: CRUDTest
 * Description:
 *
 * @Author cherry
 * @Create 2023/8/1 15:45
 * @Version 1.0
 */
public class PreparedStatementTest {
    /*
    * 通用的增删改操作接口。
    * */
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

    /**
     * 通用的查询接口
     */
    public <T> List<T> query(Class<T> clazz,String sql, Object ...args) {
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
                    Field field = t.getClass().getDeclaredField(columnLabel);
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

    @Test
    public void test1(){
        String sql = "delete from customers where id = ?";
        update(sql,18);

    }

    @Test
    public void test2(){
        String sql = "insert into customers VALUES (?,?,?,?,?)";
        java.util.Date date = new java.util.Date();
        long time = date.getTime();
        System.out.println(time);
        update(sql,22,"cher","cher@qq.com",new Date(time),"");
    }
    
    @Test
    public void test3(){
        String sql = "update customers set name = ? where id = ?";
        update(sql,"hhhh",22);
    }

    @Test
    public void test4() throws Exception {
        String sql = "select * from customers";
        Connection conection = JDBCUtils.getConection();
        PreparedStatement ps = conection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            Date birth = resultSet.getDate(4);
        }
        System.out.println(resultSet);
    }

    @Test
    public void test5(){
        String sql = "select * from customers";
        List<Customer> list = query(Customer.class, sql);
        list.forEach(System.out::println);
    }
}


