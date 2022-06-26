package com.kangjian.designpattern.mediatormodule;

import java.awt.*;

public class ColleagueButton extends Button implements Colleague {

    protected Mediator mediator;


    public ColleagueButton(String caption) {
        super(caption);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(true);
    }

}
