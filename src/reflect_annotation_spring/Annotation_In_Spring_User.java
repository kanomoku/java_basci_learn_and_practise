package reflect_annotation_spring;

public class Annotation_In_Spring_User {
    private String name;
    private String password;
    private Float balance;

    @Annotation_ZiDingYi(value = {"麻诗民", "333", "100"})
    public Annotation_In_Spring_User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
