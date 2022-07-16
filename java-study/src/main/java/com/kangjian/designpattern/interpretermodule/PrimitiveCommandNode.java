package com.kangjian.designpattern.interpretermodule;

import java.text.ParseException;

public class PrimitiveCommandNode extends Node {

    private String name;

    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);
        if (!name.equals("go") && !name.equals("right") && !name.equals("left")) {
            throw new ParseException(name + "is undefined", -1);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
