package me.zeroest.kotlin.basic.gettersetter;

import java.util.UUID;

public class Person {
    private String name;
    private Integer age;
    private String address;

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

    public String getUUID() {
        return UUID.randomUUID().toString();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String myAddress() {
        return this.address;
    }
}
