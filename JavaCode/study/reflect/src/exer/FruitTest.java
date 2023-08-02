package exer;

import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * ClassName: FruitTest
 * Package: exer
 * Description:
 *
 * @Author cherry
 * @Create 2023/7/29 16:12
 * @Version 1.0
 */
public class FruitTest {
    @Test
    public void test1() throws Exception {
        Properties properties = new Properties();
        InputStream asStream = ClassLoader.getSystemResourceAsStream("config.properties");
        properties.load(asStream);
        String fruitName = properties.getProperty("fruitName");
        //这获取的是操作类的Class的对象。
        Class clazz = Class.forName(fruitName);
        //这才是创建对象。
        Constructor constructor = clazz.getDeclaredConstructor();
        Fruit fruit = (Fruit) constructor.newInstance();
        Juicer juicer = new Juicer();
        juicer.run(fruit);
    }

    @Test
    public void test2() throws ClassNotFoundException {
        String name = "exer.Apple";
        Class clazz = Class.forName(name);
        System.out.println(clazz);
    }
}
