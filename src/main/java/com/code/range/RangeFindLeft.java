package com.code.range;

import java.util.Arrays;

/**
 * (❤️ ω ❤️)
 * 抓取目标数字最左位置（可能不存在该数字，所以找的是一个该数字正好左边数字大于 右边数字小于的位置）
 */
public class RangeFindLeft {

    public static int findLeft(int[] arr,int num){
        int seq = -1;
        int L = 0;
        int R = arr.length-1;
        while (L <= R){
            int mid = (L+R)/2;
            if(num == arr[mid]){
                return mid;
            } else if (num>arr[mid]) {
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        return seq;
    }

    public static int checkFind(int[] arr,int num){
        int seq = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num){
                return i;
            }
        }
        return seq;
    }

    public static void main(String[] args) {
        int times = 10;
        int num = 7;
        int maxLen = 20;
        int maxVal = 50;
        int findVal = 13;
        for (int i = 0; i < times; i++) {
            int[] testArr = RandomArrCheck.bubbleSort(RangeFindNum.outArr(maxLen,maxVal));
            System.out.println("数组"+ Arrays.toString(testArr) +"中："+findVal+"的最左位置");
            int a = findLeft(testArr,findVal);
            if(a == -1){
                System.out.println("该数字不存在数组中");
            }else {
                System.out.println("程序检测为【" + findLeft(testArr, findVal) + "】");
            }
            int b = checkFind(testArr,findVal);
            if(b == -1) {
                System.out.println("该数字不存在数组中");
            }else{
                System.out.println("测试程序为【" + checkFind(testArr, findVal) + "】");
            }
        }
    }
    /*
     * 数组[3, 4, 5, 7, 9, 11, 11, 15, 18, 20, 21, 23, 23, 24, 29, 32, 37, 39, 48, 48]中：13的最左位置
     * 该数字不存在数组中
     * 该数字不存在数组中
     * 数组[0, 7, 7, 9, 10, 11, 12, 14, 20, 21, 27, 30, 35, 36, 40, 43, 43, 45, 46, 47]中：13的最左位置
     * 该数字不存在数组中
     * 该数字不存在数组中
     * 数组[0, 5, 9, 13, 16, 17, 17, 19, 22, 22, 23, 24, 34, 38, 38, 39, 40, 45, 48, 49]中：13的最左位置
     * 程序检测为【3】
     * 测试程序为【3】
     * 数组[5, 7, 7, 7, 7, 9, 10, 15, 17, 17, 21, 21, 25, 27, 30, 35, 37, 38, 46, 48]中：13的最左位置
     * 该数字不存在数组中
     * 该数字不存在数组中
     * 数组[1, 3, 7, 7, 14, 16, 18, 20, 22, 23, 24, 24, 26, 27, 28, 34, 35, 43, 47, 47]中：13的最左位置
     * 该数字不存在数组中
     * 该数字不存在数组中
     * 数组[4, 5, 6, 7, 8, 10, 12, 17, 18, 19, 24, 28, 28, 29, 34, 35, 38, 42, 44, 47]中：13的最左位置
     * 该数字不存在数组中
     * 该数字不存在数组中
     * 数组[7, 7, 8, 11, 17, 18, 22, 28, 28, 29, 29, 30, 32, 35, 38, 38, 39, 40, 44, 47]中：13的最左位置
     * 该数字不存在数组中
     * 该数字不存在数组中
     * 数组[0, 4, 6, 6, 8, 8, 8, 10, 15, 16, 19, 20, 22, 24, 26, 39, 40, 43, 44, 47]中：13的最左位置
     * 该数字不存在数组中
     * 该数字不存在数组中
     * 数组[0, 1, 2, 14, 16, 19, 20, 21, 21, 23, 27, 30, 30, 31, 31, 33, 39, 39, 46, 49]中：13的最左位置
     * 该数字不存在数组中
     * 该数字不存在数组中
     * 数组[0, 3, 9, 16, 16, 17, 20, 26, 26, 28, 29, 32, 35, 42, 44, 45, 46, 46, 48, 49]中：13的最左位置
     * 该数字不存在数组中
     * 该数字不存在数组中
     *
     * 进程已结束,退出代码0
     */
}
