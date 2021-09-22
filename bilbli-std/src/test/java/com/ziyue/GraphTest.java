package com.ziyue;

import org.junit.Test;

import java.util.*;

public class GraphTest {


    private int arr[][] = {
            {0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}
    };
    private int l = Integer.MAX_VALUE;
    private int arr1[][] = {
            {0, 1, 1, 1, 1, l, l, l, l, l, l},
            {1, 0, l, l, 1, l, l, 1, l, 1, l},
            {1, l, 0, l, l, l, l, l, l, l, l},
            {1, l, l, 0, l, 1, 1, l, l, l, l},
            {1, 1, l, l, 0, 1, l, l, l, l, l},
            {l, l, l, 1, 1, 0, l, l, l, l, l},
            {l, l, l, 1, l, l, 0, l, l, l, l},
            {l, 1, l, l, l, l, l, 0, 1, l, 1},
            {l, l, l, l, l, l, l, 1, 0, l, l},
            {l, 1, l, l, l, l, l, l, l, 0, l},
            {l, l, l, l, l, l, l, 1, l, l, 0}
    };


    @Test
    public void test() {
        solutionA(arr, 0);
        System.out.println();
        solutionB(arr);
        System.out.println();
        solutionC(arr);
        System.out.println();
        int ret = solutionD(arr, 4, 10);
        System.out.println("ret:" + ret);
        System.out.println();
        int res = solutionG(arr1, 4, 10);
        System.out.println("res is: " + res);
    }


    /**
     * 基于递归实现图的遍历 ； DBS
     *
     * @param arr
     */
    boolean record[] = new boolean[arr.length];
    List<Integer> retlIst = new ArrayList<>();

    public void solutionA(int arr[][], int startIndex) {
        for (int a = 0; a < arr[startIndex].length; a++) {
            if (arr[startIndex][a] == 1) {
                if (record[a]) {
                    continue;
                }
                System.out.print(a + "\t");
                retlIst.add(a);
                record[a] = true;
                solutionA(arr, a);
            }
        }
    }

    /**
     * 基于栈实现 DFS
     *
     * @param arr
     */
    public void solutionB(int arr[][]) {
        boolean[] record = new boolean[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            Integer num = stack.pop();
            if (record[num]) {
                continue;
            }
            System.out.print(num + "\t");
            record[num] = true;
            for (int a = 0; a < arr.length; a++) {
                if (arr[num][a] == 1) {
                    stack.push(a);
                }
            }
        }
    }

    /**
     * 基于链表实现， 广度优先， 关键点， 还是要记录之前打印过的值。
     *
     * @param arr
     */
    public void solutionC(int arr[][]) {
        boolean[] record = new boolean[arr.length];
        Queue<Integer> numList = new LinkedList<>();
        numList.offer(0);
        while (!numList.isEmpty()) {
            int num = numList.poll();
            System.out.print(num + "\t");
            record[num] = true;
            for (int a = num; a < arr.length; a++) {
                if (arr[num][a] == 1 && !record[a] && !numList.contains(a)) { // 这里注意, 记录顶点的列表也要去重
                    numList.offer(a);
                }
            }
        }
    }

    /**
     * 基于链表实现， 广度优先，到达目标订单的距离
     *
     * @param arr
     */
    public int solutionD(int arr[][], int startValue, int endValue) {
        boolean[] record = new boolean[arr.length];
        Queue<Integer> numList = new LinkedList<>();
        Queue<Integer> numListA = new LinkedList<>();
        numList.offer(startValue);
        int count = -1; // 有自己和自己检索的一个过程， 为了统一起见一起放进去了
        while ((!numList.isEmpty() || !numListA.isEmpty())) {
            boolean flag = false;
            while (!numList.isEmpty()) {
                flag = true;
                int num = numList.poll();
                System.out.print(num + "\t");
                if (num == endValue) {
                    return count + 1;
                }
                record[num] = true;
                for (int a = 0; a < arr[num].length; a++) {
                    if (!record[a] && arr[num][a] == 1 && !numListA.contains(a)) {
                        numListA.offer(a);
                    }
                }
            }
            if (flag) count++;
            flag = false;
            while (!numListA.isEmpty()) {
                flag = true;
                int num = numListA.poll();
                System.out.print(num + "\t");
                if (num == endValue) {
                    return count + 1;
                }
                record[num] = true;
                for (int a = 0; a < arr[num].length; a++) {
                    if (!record[a] && arr[num][a] == 1 && !numListA.contains(a)) {
                        numList.offer(a);
                    }
                }
            }
            if (flag) count++;
        }
        return -1;
    }

    public int solutionG(int arr[][], int start, int end) {
        for (int a = 0; a < arr.length; a++) {
            for (int c = 0; c < arr.length; c++) {
                for (int tmp = 0; tmp < arr.length; tmp++) {
                    if (arr[a][c] == l || arr[c][tmp] == l) {
                        continue;
                    }
                    arr[a][tmp] = Math.min(arr[a][tmp], arr[a][c] + arr[c][tmp]);
                }
            }
        }
        return arr[start][end];
    }

}
