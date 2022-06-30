package com.kangjian.functionalapi.consumer;

import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> stringConsumer = x -> System.out.println("test: " + x);
        stringConsumer.accept("consumer");
    }
}
