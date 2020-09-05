package reflect_Ioc_Spring;

public class TestMain {
    public static void main(String[] args) {
        //创建一个Question对象 对象的控制权交由别人处理  MySpring类  IOC
        MySpring spring = new MySpring();
//        Question question = (Question) spring.getBean("reflect_Ioc_Spring.Question");
//        System.out.println(question);

        Person person = (Person) spring.getBean("reflect_Ioc_Spring.Person");
        System.out.println(person);
    }
}
