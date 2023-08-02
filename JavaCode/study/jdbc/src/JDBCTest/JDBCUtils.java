package JDBCTest;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * ClassName: JDBCUtils
 * Package: JDBCTest
 * Description:
 *  操作数据库工具类
 * @Author cherry
 * @Create 2023/8/1 15:32
 * @Version 1.0
 */
public class JDBCUtils {
    /*
    * 获取数据库连接
    * */
    public static Connection getConection() throws Exception {
        InputStream is = ClassLoader.getSystemResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        //1.加载配置文件
        properties.load(is);
        String driver = properties.getProperty("driver");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        //2.加载驱动
        Class.forName(driver);
        //3.获取连接
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);

        return connection;
    }

    public static void close(Connection conn, Statement ps){
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        }catch  (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(Connection conn, Statement ps, ResultSet rs){
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        }catch  (SQLException e){
            e.printStackTrace();
        }
        try {
            if (rs != null)
                rs.close();
        }catch  (SQLException e){
            e.printStackTrace();
        }

    }
}
