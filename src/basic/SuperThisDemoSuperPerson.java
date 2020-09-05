package basic;

public class SuperThisDemoSuperPerson extends SuperThisDemoPerson {
    SuperThisDemoSuperPerson() {
        System.out.println("SuperPerson 无参数构造方法");
    }

    SuperThisDemoSuperPerson(String name) {
        System.out.println("SuperPerson 有参数构造方法");
    }

//        public void eat(){
//        this.sleep();
//        System.out.println("superperson eat");
//    }
    public void sleep() {
        System.out.println("superperson sleep");
    }
}