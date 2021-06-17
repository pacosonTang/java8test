package com.java8.gov.lambda.basic;

public class Person {

    private String name;
    private int age;
    private Sex gender;

    public Person() {
    }
    public Person(String name, int age, Sex gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void printPerson() {
        System.out.println(toString());
    }

    /**
     * 性别枚举
     */
    public enum Sex {
        MALE, FEMALE;
    }
}
