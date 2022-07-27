package com.kangjian.oopprinciple.klp;

import lombok.Data;

@Data
public class Agent implements IAgent {

    private Star myStar;
    private Company myCompany;
    private Fans myFans;

    @Override
    public void meeting() {
        System.out.println(myFans.getName() + "与明星" + myStar.getName() + "见面了。");

    }

    @Override
    public void business() {
        System.out.println(myCompany.getName() + "与明星" + myStar.getName() + "洽淡业务。");
    }
}
