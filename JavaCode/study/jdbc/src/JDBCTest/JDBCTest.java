package JDBCTest;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * ClassName: JDBCTest
 * Package: JDBCTest
 * Description:
 *
 * @Author cherry
 * @Create 2023/8/1 11:08
 * @Version 1.0
 */
public class JDBCTest {

    @Test
    public void test1() throws Exception {
        Properties properties = new Properties();
        InputStream is = JDBCTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
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
    }
}
