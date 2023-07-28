/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.commons;

import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigureTest {

    @Test
    public void initProperties() {
        Configure configure = Configure.get();
        System.out.println(configure.getZookeeperPort());
        System.out.println(configure.getZookeeperAddr());
        System.out.println(configure.getMQConfig());
    }

    @Data
    static class DataModel {
        List<Integer> names;
    }


    public static void main(String[] args) {
        System.out.println("hello word");
        DataModel dataModel = new DataModel();
        dataModel.setNames(Arrays.asList(1, 3, 4, 5, 6, 8, 9));
        List<Integer> tetDatas = dataModel.getNames();
        tetDatas = dataModel.getNames().stream().filter(t -> t < 5).collect(Collectors.toList());
        System.out.println(tetDatas);
        System.out.println(dataModel.getNames());
    }

}
