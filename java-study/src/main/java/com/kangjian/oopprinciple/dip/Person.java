package com.kangjian.oopprinciple.dip;

public class Person {

    public void study(Course course) {
        course.study();
    }

    public static void main(String[] args) {
       Person person = new Person();
       person.study(new JavaSourse());
       person.study(new CplusCourse());
    }
}
