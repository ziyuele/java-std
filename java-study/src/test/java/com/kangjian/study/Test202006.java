package com.kangjian.study;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test202006 {


    @Test
    public void testDate() {
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.withTimeAtStartOfDay().toString("yyyMMdd MMHHss"));
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Object> completableFuture = CompletableFuture.supplyAsync(() -> {
//            throw new RuntimeException();
//        }).exceptionally(e -> {
//            return "dddddd";
//        });
//        CompletableFuture<String> ret = completableFuture.thenApply(t -> "hahahaha");
//        completableFuture.whenComplete((s,e) -> System.out.println(s));
//        CompletableFuture.allOf(completableFuture, ret).join();
//        System.out.println(ret.get(get));

        for (int a = 0; a < 100; a ++) {
            String s = System.currentTimeMillis() + "";

            if (StringUtils.isNotEmpty(s)) {
                if (System.currentTimeMillis() < Long.parseLong(s)) {
                    break;
                }
                System.out.println("test-");
            }
            System.out.println("test-a" + a);
        }

    }

}
