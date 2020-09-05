package collection_list;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SortListUtil_Student_No_Implements_Comparable {
    private Long userId;
    private String userName;
    private String password;
    private Date birthday;
    private Integer sex;
    private Integer age;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String getBirthdayStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(getBirthday());
    }

    public String toString() {
        return "Student{" +
                "userId=" + userId +
                ", userName=" + userName +
                ", password=" + password +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", age='" + age + '\'' +
                '}';
    }
}
