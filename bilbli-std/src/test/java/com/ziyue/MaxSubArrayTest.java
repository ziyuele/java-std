package com.ziyue;

import com.oracle.tools.packager.mac.MacAppBundler;
import org.junit.Test;

import java.util.*;

public class MaxSubArrayTest {

    @Test
    public void doTest() {
        //int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        //System.out.println(solution(arr));

//        int[] a = {0};
//        int m = 0;
//        int[] b = {1};
//        int n = 1;
//
//        merge(a, m, b, n)n;

        //int [][] arr = {
        //        {1,2,3,4,5,6,7,8,9,10}
        //};
        generate(5);
    }

    // 动态规划， 基本思路, 前一个值如果大于0， 那么继续加入， 否则放弃
    public int solution(int[] arr) {
        int max = arr[0];
        for (int a = 1; a < arr.length; a++) {
            if (arr[a -1] > 0) {
                arr[a] = arr[a-1] + arr[a];
            }
            max = Integer.max(arr[a], max);
        }
        return max;
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1, r = n - 1;
        int tail = m + n -1;
        while (tail >= 0) {
            if (r < 0) {
                nums1[tail--] = nums1[l--];
            } else if (l < 0) {
                nums1[tail--] = nums1[r--];
            } else if (nums1[l] >= nums2[r]) {
                nums1[tail--] = nums1[l--];
            } else if (nums1[l] < nums2[r]) {
                nums1[tail--] = nums2[r--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }


    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if((mat.length * mat[mat.length - 1].length) != (r * c)) {
            return mat;
        }
        int[][] arr = new int[r][c];
        int count = 0;
        for (int a = 0; a < mat.length; a ++) {
            for (int b = 0; b < mat[a].length; b ++) {
                if (c == 1) {
                    arr[count][0] = mat[a][b];
                } else if (r == 1) {
                    arr[0][count] = arr[a][b];
                } else {
                    arr[count / c][count % c ] = mat[a][b];
                }
                count ++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ret = new ArrayList<>(numRows);
            List<Integer> pre = new ArrayList<>();
            pre.add(1);
            for (int a = 0; a < numRows ; a ++) {
                List<Integer> cur = new ArrayList<>(a + 1);
                for (int b = 0; b <= a; b++) {
                    if (b == 0) {
                        cur.add(pre.get(b));
                    } else if (b > pre.size() -1) {
                        cur.add(pre.get(b -1));
                    } else {
                        cur.add(pre.get(b - 1) + pre.get(b ));
                    }
                }
                ret.add(cur);

                pre = cur;
            }
            System.out.println(ret);
            return ret;
        }
}
