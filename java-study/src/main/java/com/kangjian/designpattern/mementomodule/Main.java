package com.kangjian.designpattern.mementomodule;

/**
 *  Caretaker 角色
 */
public class Main {
    public static void main(String[] args) {
       Gamer gamer = new Gamer(100);
       Memento memento = gamer.createMento();

       for (int i = 0; i < 100; i ++) {
           System.out.println("=========== round:" + i);
           System.out.println("当前状态：" + gamer);

           gamer.bet();

           System.out.println("所持金钱为: ¥" + gamer.getMoney());
           if (gamer.getMoney() > memento.money) {
               System.out.println("因为持有金钱增加， 保留当前游戏状态");
               memento = gamer.createMento();
           } else if (gamer.getMoney() < memento.money / 2) {
                System.out.println("因为持有金钱减半了， 所以恢复只以前的状态[重玩]");
                gamer.restoreMemento(memento);
           }

           try {
               Thread.sleep(1000);
           } catch (Exception e) {
               //ignore
           }
       }

    }
}
