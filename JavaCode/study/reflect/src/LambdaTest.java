import org.junit.Test;

import java.util.Comparator;

/**
 * ClassName: LambdaTest
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author cherry
 * @Create 2023/7/31 10:04
 * @Version 1.0
 */
public class LambdaTest {
    @Test
    public void test1(){
        Runnable r = () -> {
            System.out.println("你好");
        };
        r.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> com2 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        Comparator<Integer> com1 = (Integer o1, Integer o2) -> {
            return Integer.compare(o1,o2);
        };
        System.out.println(com1.compare(1,2));

        //简化版
        Comparator<Integer> com3 = (i1,i2) -> Integer.compare(i1,i2);

        //方法引用
        Comparator<Integer> com4 = Integer::compare;
        System.out.println(com4.compare(1, 2));
    }
}
