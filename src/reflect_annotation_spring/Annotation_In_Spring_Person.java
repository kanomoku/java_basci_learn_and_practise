package reflect_annotation_spring;

public class Annotation_In_Spring_Person {
    private String name;
    private Integer age;
    private String sex;

    @Annotation_ZiDingYi( value = {"麻诗民", "1314", "张紫涵"})
    public Annotation_In_Spring_Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    //利用反射技术实现一个IOC 对象由别人来创建 创建同时自动注入属性信息
    //自动注入属性的信息----------> 原来是Scanner String字符串  现在可以用 存入文件 或者  产生一个注解携带这些信息


}
