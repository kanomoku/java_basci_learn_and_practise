package basic;

public class SuperThisDemoTest {
    public static void main(String[] args) {
        SuperThisDemoSuperPerson p = new SuperThisDemoSuperPerson();
        System.out.println();

        SuperThisDemoSuperPerson p1 = new SuperThisDemoSuperPerson("aa");
        System.out.println();

        SuperThisDemoPerson p2 = new SuperThisDemoPerson();
//        System.out.println(p2.name);
        p2.eat();
        System.out.println();

        SuperThisDemoSuperPerson p3 = new SuperThisDemoSuperPerson("aa");
        p3.eat();

    }
}
