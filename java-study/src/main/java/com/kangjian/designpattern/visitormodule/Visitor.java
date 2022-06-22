package com.kangjian.designpattern.visitormodule;

public abstract class Visitor {

    public abstract void visit(TFile file);
    public abstract void visit(TDirectory directory);
}
