package me.zeroest.kotlin.basic.gettersetter;

import java.time.LocalDate;

public class JavaGetterSetter {
    public static void main(String[] args) {
        Student student = new Student();

        student.setName("zero");
        student.setBirthDate(LocalDate.of(1992, 10, 17));
//        student.setAge(31);
        student.age = 31;
//        student.setAddress("moon");
        student.changeAddress("moon");

        System.out.println("student.getName() = " + student.getName());
        System.out.println("student.getBirthDate() = " + student.getBirthDate());
//        System.out.println("student.getAge() = " + student.getAge());
        System.out.println("student.getAge() = " + student.age);
        System.out.println("student.getAddress() = " + student.getAddress());

    }
}
