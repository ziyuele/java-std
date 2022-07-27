package com.kangjian.tmptestmt;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Test202103 {


    @Test
    public void testStringFormat() {
        double num = 3d;
        System.out.println(String.format("%.1f", num));
    }

    @Test
    public void testThenApplay() {
        long time = System.currentTimeMillis();
        CompletableFuture<Integer> completableFuture = CompletableFuture.completedFuture(1);
       CompletableFuture completableFuture1 =  completableFuture.thenApply( s -> {
            return  2;
        });

       CompletableFuture completableFuture2 =  completableFuture1.thenApplyAsync( t -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            return 1;
        });
        CompletableFuture completableFuture3 =  completableFuture1.thenApplyAsync( t -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            return 1;
        });
        CompletableFuture.allOf(completableFuture1, completableFuture2, completableFuture3).join();
        System.out.println(System.currentTimeMillis() - time);
    }
}
