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

        completableFuture.thenApplyAsync( t -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            return 1;
        });
        completableFuture.thenApplyAsync( t -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            return 1;
        });
        System.out.println(System.currentTimeMillis() - time);
    }
}
