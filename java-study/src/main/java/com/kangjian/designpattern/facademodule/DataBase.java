package com.kangjian.designpattern.facademodule;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    public Map<String, String> map;
    public DataBase() {

        map = new HashMap<>();
        map.put("1", "kangjian");
        map.put("2", "jiangkang");
        map.put("3", "wurenzhixiao");
    }

    public  String getUserName(String key) {
        return map.get(key);
    }
}
