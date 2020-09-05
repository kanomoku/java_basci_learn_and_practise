package reflect_FanShe;

public class Reflect_Person_Extends_Animal extends Reflect_Animal {

    public String name;
    public int age;
    private String wife;

    public Reflect_Person_Extends_Animal() {
        System.out.println("我是Reflect_Person_Extends_Animal无参数的构造方法");
    }

    public Reflect_Person_Extends_Animal(String name) {
        System.out.println("我是Reflect_Person_Extends_Animal的String类型参数的构造方法");
    }

    public void eat() {
        System.out.println("吃空");
    }

    public void eat(String food) {
        System.out.println(food);
    }

    private void testPrivate() {
        System.out.println("我是私有方法");
    }

    private void drink() {
        System.out.println("人喝");
    }

    private void drink(String str) {
        System.out.println("人吃" + str);
    }

    public String toString() {
        return "{" + name + "," + age + "}";
    }
}
