package com.ziyue.reactor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ApplicationLoader {
    public String f1() {
        return "f1";
    }

    public String f2(String s1) {
        return s1 + "_f2";
    }

    public String f4(String s2, String s3) {
        return s2+s3 + "_f3";
    }

    public String f3(String s1) {
        return s1 + "_f3";
    }

    public String f5(String s3) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + ":" + Thread.currentThread().getName());
        try {Thread.sleep(1000);} catch (Exception e) {}
        return s3 + "_f5";
    }



    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data {
        String f2Ret;
        String f3Ret;
        String f4Ret;
        String f5Ret;
    }

    public void defaultImplement() {
        long currnetTime = System.currentTimeMillis();
        String f1Ret = f1();
        String f2Ret = f2(f1Ret);
        String f3Ret = f3(f1Ret);
        String f4Ret = f4(f2Ret, f3Ret);
        String f5Ret = f5(f3Ret);
        System.out.println(new Data(f2Ret, f3Ret, f4Ret, f5Ret));
        System.out.println(System.currentTimeMillis() - currnetTime);
    }


    public void completeableImplement() throws Exception {
        long currnetTime = System.currentTimeMillis();
        Data data = new Data();
        // s1
        CompletableFuture<String> f1f = CompletableFuture.supplyAsync(() -> f1());
        // s2
        CompletableFuture<String> f2f = f1f.thenApplyAsync(this::f2);
        CompletableFuture<String> f3f = f1f.thenApplyAsync(this::f3).exceptionally(e -> {return null;});;
        f2f.thenAccept(data::setF2Ret);
        f3f.thenAccept(data::setF3Ret);

        // s3
        CompletableFuture<String> f4f = f2f.thenCombineAsync(f3f, this::f4);
        f4f.thenAccept(data::setF4Ret);
        CompletableFuture<String> f5f = f3f.thenApplyAsync(this::f5);
        f5f.thenAccept(data::setF5Ret);

        f1f.get();
        CompletableFuture.allOf(f1f, f2f, f3f, f4f, f5f).join();
        System.out.println(data);
        System.out.println(System.currentTimeMillis() - currnetTime);
    }

    static Thread t;
    // 模拟接口层， 请求进来
    public static void main(String[] args) throws Exception {
        System.out.println(new ApplicationLoader().facadeFunction());
    }


    /**
     *  模拟接口层， 主要两个只能：
     *  1. 按照业务需求获取数据， 生成completeFeature
     *  2. 调用下一层服务， 进行内存封装
     */
    public Map<String, String> facadeFunction() {
        CompletableFuture<String> s1f = CompletableFuture.supplyAsync(this::f1);
        CompletableFuture<String> s2f = s1f.thenApplyAsync(this::f2);
        CompletableFuture<String> s3f = s1f.thenApplyAsync(this::f3);

        CompletableFuture<String> funtion1Ret = serviceFunction1(s1f);
        CompletableFuture<String> funtion2Ret = serviceFunctino2(s2f, s3f);
        Map<String, String> ret =new HashMap<>();
        funtion1Ret.thenAccept(s -> ret.put("aa", s));
        funtion2Ret.thenAccept(s -> ret.put("bb", s));
        CompletableFuture.allOf(funtion1Ret, funtion2Ret).join();
        return ret;
    }

    /**
     *  模拟服务层的一个领域功能a
     */
    public CompletableFuture<String> serviceFunction1(CompletableFuture<String> s1f) {
        return s1f.thenApply(s -> "aa__" + s);
    }

    /**
     *  模拟服务层的一个领域功能b
     */
    public CompletableFuture<String> serviceFunctino2(CompletableFuture<String> s2f, CompletableFuture<String> s3f) {
        return s2f.thenCombine(s3f, (a, b) -> "bb__" + a + b);
    }
}

