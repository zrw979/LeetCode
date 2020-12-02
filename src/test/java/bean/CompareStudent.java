package bean;

import java.util.Comparator;

/**
 * @ProjectName: leetCode
 * @Package: bean
 * @ClassName: CompareStudent
 * @Author: JamZhang
 * @Description: ${description}
 * @Date: 2020/10/6 16:20
 * @Version: 1.0
 */
public class CompareStudent implements Comparable<CompareStudent> {

    private String name;
    private Integer age;
    private Boolean avaliable;

    public CompareStudent(String name, Integer age, Boolean avaliable) {
        this.name = name;
        this.age = age;
        this.avaliable = avaliable;
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

    public Boolean getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(Boolean avaliable) {
        this.avaliable = avaliable;
    }

    @Override
    public String toString() {
        return "CompareStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", avaliable=" + avaliable +
                '}';
    }

    @Override
    public int compareTo(CompareStudent o) {
        //return this.getName().compareTo(o.getName());
        //return this.getName().length() - o.getName().length();
        return o.getAge() - this.getAge();
    }
}
