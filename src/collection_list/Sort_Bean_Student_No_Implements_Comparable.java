package collection_list;

public class Sort_Bean_Student_No_Implements_Comparable {
    private Integer age;
    private Integer score;
    private String name;

    public Sort_Bean_Student_No_Implements_Comparable() {
    }

    public Sort_Bean_Student_No_Implements_Comparable(Integer age, Integer score, String name) {
        this.age = age;
        this.score = score;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}
