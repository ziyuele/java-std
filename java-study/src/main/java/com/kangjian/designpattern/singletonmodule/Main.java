package com.kangjian.designpattern.singletonmodule;

public class Main {
    private static final Object lock = new Object();
    public static void main(String args[]) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

        if(singleton == singleton1){
            System.out.println("the same instance");
        } else {
            System.out.print("different instance");
        }
        if(singleton.equals(singleton1)) {
            System.out.println("instance value is the same singleton");
        }

        Test test = new Test();
        Test test1 = new Test();
        if(test == test1) {
            System.out.println("the same instance test");
        } else {
            System.out.println("different instance test");
        }
        if (test1.equals(test)){
            System.out.println("instance value is the sane test");
        }
        String s = "dfsaf";
        s.equals("dfs");
        synchronized (lock) {

        }

    }
}
