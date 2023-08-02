/**
 * ClassName: Person
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author cherry
 * @Create 2023/7/28 16:50
 * @Version 1.0
 */
public class Person {
    private String name;
    public int age;

    public Person() {
        System.out.println("Public Person...");
    }

    private Person(String name, int age) {
        System.out.println("Private Person...");
        this.name = name;
        this.age = age;
    }

    public void show(){
        System.out.println("你好，我是一个Person");
    }

    private String showNation(String nation){
        return "我的国籍是：" + nation;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
