package com.ziyue.reactor;

import reactor.core.publisher.Flux;

public class ApplicationLoader {
    public static void main(String[] args) throws Exception {
        Flux.just(ApplicationLoader.doTest()).subscribe(
               t -> {System.out.println(t);},
               s -> {System.err.println(s);}
        );
        System.out.println("hahahahahaha");
        Thread.sleep(40);
    }

    public static String doTest() throws Exception {
        System.out.println("this is a test");
        Thread.sleep(3000);
        //throw new RuntimeException("EROOR 了哈哈哈");
        return "RET_OK";
    }
}
