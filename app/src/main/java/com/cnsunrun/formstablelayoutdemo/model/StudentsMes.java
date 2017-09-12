package com.cnsunrun.formstablelayoutdemo.model;

/**
 * Created by ZhouBin on 2017/9/12.
 * Effect: 信息的实体类
 */

public class StudentsMes {

    private String name;
    private String age;
    private String gender;
    private String address;

    public StudentsMes(String name, String age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
