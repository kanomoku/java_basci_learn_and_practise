package basic;

public class SuperThisDemoPerson extends SuperThisDemoAnimal {
    public String name = super.name;

    SuperThisDemoPerson() {
        System.out.println("Person 无参数构造方法");
    }

    SuperThisDemoPerson(String name) {
        System.out.println("Person 有参数构造方法");
    }

    public void eat() {
        this.sleep();
        super.sleep();
        System.out.println("person eat");
    }

    public void sleep() {
        System.out.println("perosn sleep");
    }
}