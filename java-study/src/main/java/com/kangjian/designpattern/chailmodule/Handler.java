package com.kangjian.designpattern.chailmodule;

import java.util.Objects;

public abstract class Handler {
    private String name;
    private Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public Handler(String name) {
        this.name = name;
    }

    public final void support(Trouble t) {
        if (resloulve(t)) {
            done(t);
        } else if (Objects.nonNull(next)) {
            System.out.println(name + " not support problem" + "[" + t + "]");
            next.support(t);
        } else {
            failed(t);
        }
    }

    protected final void failed(Trouble t) {
       System.out.println("Can not resoulve it, this is final handler : " + name);
    }

    protected abstract boolean resloulve(Trouble t);

    protected final void done(Trouble t) {
        System.out.println("problem done :" + name);
    }
}
