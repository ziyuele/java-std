package com.kangjian.study.abstractanddata;

public  class People implements IPeople {

    private String name = "test";

    private Integer age = 14;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }
}
