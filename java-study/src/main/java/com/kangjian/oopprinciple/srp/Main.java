package com.kangjian.oopprinciple.srp;

public class Main {

    public static void main(String[] args) {
        CommonUser commonUser = new CommonUser();
        commonUser.study("common");
        VipUser vipUser = new VipUser();
        vipUser.study("vip");
    }
}
