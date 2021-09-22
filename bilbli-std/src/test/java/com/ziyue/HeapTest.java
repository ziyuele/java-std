package com.ziyue;

import org.junit.Test;

import java.util.Arrays;

public class HeapTest {

    @Test
    public void doTest() {
        int arr[] = {9, 8, 6, 7, 4, 3, 0, 0, 0};
        int[] ret = addHeap(arr, 6, 11);
        System.out.println(Arrays.toString(ret));
        int[] delret = delHeap(arr, 7);
        System.out.println(Arrays.toString(delret));
        int[] delretV = delHeapV(arr, 6);
        System.out.println(Arrays.toString(delretV));
    }

    /**
     *  堆插入， 添加元素： 上浮的过程
     */
    public int[] addHeap(int arr[], int currentSize, int num) {
        arr[currentSize] = num;
        int index = currentSize;
        while (index > 0 && arr[(index -1) / 2] < num) {
            int newIndex = (index -1) / 2;
            arr[index] = arr[newIndex];
            arr[newIndex] = num;

            index = newIndex;
        }
        return arr;
    }

    public int[] delHeap(int arr[], int currentSize) {
       arr[0] = arr[currentSize - 1];
       arr[currentSize -1] = 0;
       int currentIndex = 0;
       int indx = 0 * 2 + 1;
       while (indx  < currentSize -1) {
            if (arr[indx] < arr[indx + 1]) {
                indx = indx + 1;
            }
            if (arr[indx] > arr[currentIndex]) {  // 其中， 这个中间过程的最终值替换可以省略， 减少一次中间存储的过程
                int tmp = arr[indx];              // 可以看下方的数据描述
                arr[indx] = arr[currentIndex];
                arr[currentIndex] = tmp;
                indx = currentIndex;
                indx = indx * 2 + 1;
            } else {
                break;
            }
       }
       return arr;
    }

    public int[] delHeapV(int arr[], int currentSize) {
        arr[0] = arr[currentSize - 1];
        arr[currentSize - 1] = 0;
        int currentIndex = 0;
        int tmp = arr[0];
        int indx = 1;
        while (indx  < currentSize -1) {
            if (arr[indx] < arr[indx + 1]) {
                indx = indx + 1;
            }
            if (arr[indx] > tmp) {
                arr[currentIndex] = arr[indx]; // 当前的值交换
                currentIndex = indx; // 当前的索引交换
                indx = indx * 2 + 1;
            } else {
                break;
            }
        }
        arr[currentIndex] = tmp;
        return arr;
    }

}
