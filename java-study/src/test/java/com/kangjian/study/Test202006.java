package com.kangjian.study;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.joda.time.DateTime;
import org.junit.Test;
import org.omg.CORBA.StringHolder;

import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

import static com.sun.tools.doclint.Entity.*;

public class Test202006 {

    private Integer s = 5;
    public  int anInt = 3;


    public void test() {
        try {
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Objects.equals(anInt, s));
    }

    @Test
    public  void coupyOnwrte() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        System.out.println(Optional.ofNullable(integers).orElse(Collections.emptyList()));
    }

    @Test
    public void testDate() {
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.withTimeAtStartOfDay().toString("yyyMMdd MMHHss"));
    }
    class MyException extends Exception {
        public MyException(String message) {
            super(message);
        }
    }


    class MyNewException extends Exception {
        public MyNewException(String message) {
            super(message);
        }
    }


    @Test
    public void testException() throws MyException {
        try {
           throw new MyException("my Exception");
        } catch (MyException e) {
            System.out.println("hit");
            throw e;
        } catch (Exception be) {
           System.out.println("dddd");
        }

    }

    public static void main(String[] args) throws Exception {
        TestIface1Impl iface1 = new TestIface1Impl();
        Method[] methods =  iface1.getClass().getMethods();
        for (Method m :methods)  {
            System.out.println(m.isSynthetic());
            System.out.println("m:" + m.getName());
        }
    }


}
