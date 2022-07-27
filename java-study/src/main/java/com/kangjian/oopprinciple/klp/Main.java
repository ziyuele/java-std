package com.kangjian.oopprinciple.klp;

public class Main {
    public static void main(String[] args) {
        Agent agent = new Agent();
        agent.setMyStar(new Star("林心如"));
        agent.setMyFans(new Fans("粉丝韩丞"));
        agent.setMyCompany(new Company("中国传媒有限公司"));
        agent.meeting();
        agent.business();
    }
}
