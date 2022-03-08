package com.kangjian.designpattern.strategymodule;


public class Main {

    public static void main(String[] args) {
        int seed1 = 1;
        int seed2 = 2;

        Context context = new Context("kangjian", new ConcreteStrategy1(seed1));
        Context context1 = new Context("ziyuele", new ConcreteStrategy2(seed2));

        for (int i = 0; i < 100; i++) {

            Head head = context.nextHand();
            Head head1 = context1.nextHand();
            if (head.isStrongerThan(head1)) {
                System.out.println("Winner: " + context);
                context.win();
                context1.lose();
            } else if (head1.isStrongerThan(head)) {
                System.out.println("Winner: " + context1);
                context1.win();
                context.lose();
            } else {
                System.out.println("Even... ");
                context.even();
                context1.even();
            }

        }

        System.out.println("Total result:");
        System.out.println(context.toString());
        System.out.println(context1.toString());
    }
}
