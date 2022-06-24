package com.kangjian.designpattern.chailmodule;

import lombok.Data;

@Data
public class Trouble {

    private int data;

    public Trouble(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
