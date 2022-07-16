package com.kangjian.designpattern.interpretermodule;

import java.text.ParseException;

public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
}
