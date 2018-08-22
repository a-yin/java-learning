package com.lingb.mystudy.java.day05.collection;

/**
 * Created by lingb on 2018/7/16
 */
public class Person implements Comparable{

    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        if (!name.equals(person.name)) {
            return false;
        }
        return age.equals(person.age);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }

    /**
     * 当向TreeSet中添加Person类的对象时，依据此方法，确定按照哪个属性排序
     *
     * @param   [o]
     * @return  int
     */
    @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
//            return this.name.compareTo(p.name);
//            return this.age.compareTo(p.age);
            int i = this.name.compareTo(p.name);
            // name 相同
            if (i == 0) {
                // 比较age
                return this.age.compareTo(age);

            } else {
                return i;

            }
        }
        return 0;
    }
}
