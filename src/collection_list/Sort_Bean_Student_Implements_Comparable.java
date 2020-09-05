package collection_list;

public class Sort_Bean_Student_Implements_Comparable implements Comparable<Sort_Bean_Student_Implements_Comparable> {

    private Integer age;
    private Integer score;
    private String name;

    public Sort_Bean_Student_Implements_Comparable() {
    }

    public Sort_Bean_Student_Implements_Comparable(Integer age, Integer score, String name) {
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
    public int compareTo(Sort_Bean_Student_Implements_Comparable o) {
        //先按照年龄排序
        Integer i = this.age.compareTo(o.getAge());
        if (i == 0) {
            //如果年龄相等，则按照分数排序
            i = this.score.compareTo(o.getScore());
            if (i == 0) {
                //如果分数相等，则按照姓名排序
                i = this.getName().compareTo(o.getName());
            }
        }
        /**
         * i等于0的时候表示相等；
         * i等于1的时候表示大于；
         * i等于-1的时候表示小于；
         */
        return i;
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
