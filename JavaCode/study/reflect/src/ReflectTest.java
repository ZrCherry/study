import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ClassName: ReflectTest
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author cherry
 * @Create 2023/7/28 16:50
 * @Version 1.0
 */
public class ReflectTest {
    @Test
    public void test1(){
        //创建实例对象
        Person p1 = new Person();

        //调用public属性和方法
        p1.age = 1;
        System.out.println(p1.age);
        p1.show();
    }

    /**
     * 使用反射完成上述操作
     */
    @Test
    public void test2() throws Exception {
        Class<Person> clazz = Person.class;
        Person p1 = clazz.newInstance();
        //调用public属性
        Field age = clazz.getField("age");
        age.set(p1,10);
        System.out.println(age.get(p1));
        //获取public方法
        Method show = clazz.getMethod("show");
        show.invoke(p1);
    }

    /**
     * 反射可以调用私有的属性，方法和构造器。
     */
    @Test
    public void test3() throws Exception {
        //调用私有构造器
        Class<Person> clazz = Person.class;
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        Person p1 = constructor.newInstance("Tom", 12);
        System.out.println(p1);

        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"jerry");
        System.out.println(name.get(p1));

        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        System.out.println(showNation.invoke(p1, "中国"));
    }

    @Test
    public void test4() throws ClassNotFoundException {
        //方式一：通过运行时类的静态属性Class
        Class clazz1 = Person.class;

        //方式二：通过对象的getClass()方法
        Person p1 = new Person();
        Person p2 = new Student();
        Class clazz2 = p1.getClass();
        Class clazz3 = p2.getClass();
        System.out.println(clazz1==clazz2);     //true
        System.out.println(clazz2);     //class Person
        System.out.println(clazz3);     //class Student
        //方式三:调用Class的静态方法forName(String className)
        Class clazz4 = Class.forName("Person");
        System.out.println(clazz1 == clazz4);   //ture
        //方法四:使用类的加载器
        Class clazz5 = ClassLoader.getSystemClassLoader().loadClass("Person");
        System.out.println(clazz1 == clazz5);   //true
    }

}
