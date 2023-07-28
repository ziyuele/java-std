package com.kangjian.study;

import lombok.Data;

public class TestObject {


    // 新接口
    @Data
    class ObjectA {

        String commonValue;
    }



    // 老接口
    @Data
    class ObjectB {

        Integer intergerValue;

        String strinValue;

        String commonValue;
    }




    // 聚合里的Object
    @Data
    class ObjectC {

        Integer intergerValue;

        String strinValue;

        String commonValue;
    }



    public void setValue() {
       ObjectA objectA = new ObjectA();
       ObjectB objectB = new ObjectB();
    }



}
