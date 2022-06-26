package com.kangjian.designpattern.mediatormodule;


public interface Colleague {


    abstract void setMediator(Mediator mediator);
    abstract void setColleagueEnabled(boolean enabled);
}
