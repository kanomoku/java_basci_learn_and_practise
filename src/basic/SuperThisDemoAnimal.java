package basic;

public class SuperThisDemoAnimal {
    public String name = "animal";
    SuperThisDemoAnimal() {
        System.out.println("Animal 无参数构造方法");
    }

    SuperThisDemoAnimal(String name) {
        System.out.println("Animal 有参数构造方法");
    }

    public void eat() {
        this.sleep();
        System.out.println("animal eat");
    }

    public void sleep() {
        System.out.println("animal sleep");
    }
}