package com.ziyue;

import org.junit.Test;

import java.util.Stack;

public class IsValidTest {

    @Test
    public void doTest() {
       String s = "{}]";
       System.out.println(isValid(s));
    }

    public static  boolean isValid(String s) {
        Stack<String> stack = new Stack();
        for (int a = 0; a < s.length(); a ++) {
            String cs = s.substring(a, a+1);
            if (stack.isEmpty()) {
                stack.push(cs);
            } else {
                String s1 = stack.pop();
                if ("{".equals(s1) && "}".equals(cs) ||
                   "(".equals(s1) && ")".equals(cs) ||
                 "[".equals(s1) && "]".equals(cs)) {
                    continue;
                } else {
                    stack.push(s1);
                    stack.push(cs);
                }
            }
        }

        return stack.isEmpty();
    }
}
