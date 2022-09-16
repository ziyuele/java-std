package com.kangjian.reflect;

import java.util.List;

public class OrderDetailPage extends AbstractPage<Response, List<String>> implements IDetailPage {
    @Override
    public void getPage() {
        response.add("hahaha");
       System.out.println("hello word");
    }

    public static void main(String[] args) {

       System.out.println( new OrderDetailPage().build());
    }
}
