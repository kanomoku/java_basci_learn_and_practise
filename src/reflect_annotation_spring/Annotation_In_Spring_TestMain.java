package reflect_annotation_spring;

public class Annotation_In_Spring_TestMain {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        try {
            //获取一个Person对象 不用自己处理 跟别人要 MySpring
            //对象的创建权利反转 管理(IOC) 赋值(DI) 别人处理
            Annotation_In_Spring ms = new Annotation_In_Spring();//管理者 帮我们创建对象 自动复制
            Annotation_In_Spring_Person person1 = (Annotation_In_Spring_Person) ms.getBean("reflect_annotation_spring.Annotation_In_Spring_Person");
            System.out.println(person1.getName() + person1.getAge() + person1.getSex());

            Annotation_In_Spring_User user = (Annotation_In_Spring_User) ms.getBean("reflect_annotation_spring.Annotation_In_Spring_User");
            System.out.println(user.getName() + "~~~" + user.getPassword() + "~~~" + user.getBalance());

            Annotation_In_Spring_Question q = (Annotation_In_Spring_Question) ms.getBean("reflect_annotation_spring.Annotation_In_Spring_Question");
            System.out.println(q.getTitle() + "~~~" + q.getAnswer());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
