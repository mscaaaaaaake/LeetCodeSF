package com.code.range;

import java.util.Arrays;

/**
 * 有序数据组中找到num
 * 二分法
 * 每次对半，对比中间数字与寻找的数字的大小
 */
public class RangeFindNum {

    public static boolean findNum(int[] arr,int num){
        //利用二分法通过对比小段数组中左右两端数字的大小，找到目标是数字
        //起点为0，终点为中间位置
        int startSeq = 0;
        int endSeq = arr.length - 1;
        while (startSeq <= endSeq){
            int mid = (startSeq + endSeq)/2;
            if(num == arr[mid]) {
                return true;
            }else if(num > arr[mid]){
                startSeq = mid +1;
            } else{
                endSeq = mid -1;
            }
        }
        return false;
    }

    public static boolean testFind(int[] arr,int num){
        for (int j : arr) {
            if (j == num) {
                return true;
            }
        }
        return false;
    }

    public static int[] outArr(int maxLen,int maxVal){
        int[] arr = new int[maxLen];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*maxVal);
        }
        return arr;
    }


    public static void main(String[] args) {
        //多组数据检测样本
        int times = 100;
        int num = 13;
        //谨记，二分法查找数字应用的数组应该为排序后的数组
        for (int i = 0; i < times; i++) {
            int[] arr = RandomArrCheck.bubbleSort(outArr(10,100));
            if(findNum(arr,num) == testFind(arr,num) && findNum(arr,num)){
                System.out.println(Arrays.toString(arr)+"中发现目标数字"+"【"+num+"】");
                System.out.println("-----------------------------------------------------");
            }else if(findNum(arr,num) != testFind(arr,num)){
                System.out.println(Arrays.toString(arr)+"不通过");
                System.out.println("-----------------------------------------------------");
            }
        }

    }
    /*
     * 输出为
     *  [1, 13, 18, 29, 35, 56, 63, 71, 85, 90]中发现目标数字【13】
        -----------------------------------------------------
        [13, 17, 23, 57, 60, 66, 67, 73, 76, 92]中发现目标数字【13】
        -----------------------------------------------------
        [5, 5, 13, 17, 19, 64, 79, 86, 88, 91]中发现目标数字【13】
        -----------------------------------------------------
        [2, 13, 17, 34, 54, 61, 67, 72, 94, 94]中发现目标数字【13】
        -----------------------------------------------------
        [13, 15, 28, 28, 46, 62, 62, 89, 93, 97]中发现目标数字【13】
        -----------------------------------------------------
        [9, 13, 15, 21, 32, 34, 46, 51, 73, 96]中发现目标数字【13】
        -----------------------------------------------------
        [8, 13, 15, 25, 52, 57, 70, 72, 75, 86]中发现目标数字【13】
        -----------------------------------------------------
        [13, 21, 39, 40, 43, 59, 64, 68, 84, 94]中发现目标数字【13】
        -----------------------------------------------------

        进程已结束,退出代码0

     */
}
