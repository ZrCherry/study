package DruidTest;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * ClassName: JDBCUtils
 * Package: DruidTest
 * Description:
 *
 * @Author cherry
 * @Create 2023/8/15 14:53
 * @Version 1.0
 */
public class JDBCUtils {
    private static DataSource dataSource;
    static {
        Properties pros = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream("druid.properties");
        try {
            pros.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
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
