package com.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CodeSeq {


    //选择排序(将第一个数字与后面所有数字对比，小的放在第一个位置，以此类推，第二个数字也是相同做法
    private static void SelectionSort(Integer[] N){
        System.out.println(Arrays.toString(N));
        for (int i = 0;i<N.length;i++){
            //循环出数组里最小的数字
            int minI = i;//获取目前为止
            for(int j = i+1;j<N.length;j++) {//筛选目前为止至最后一个数区间最小值
                minI = N[j] < N[minI] ? j: minI;//两两对比遍历完全部数字发现最小值的位置
            }
            switchNum(N,i,minI);//将最小值和当前遍历至的位置的数字进行交换
        }
        System.out.println("选择排序后："+Arrays.toString(N));
    }


    //冒泡排序（相邻数字两两对比交换
    public static void bubbleSort(Integer[] arr){
        //对数组排序，谁大谁往后
        System.out.println(Arrays.toString(arr));
        //先确定排序范围 对于0到 n-1之间进行排序
        for(int i = arr.length -1;i >= 0;i--){
            //对于0到n-1的数据进行倒序循环两两对比
            for(int j = 1; j < arr.length ;j++){
                //对比第一个和第二个数字 0 1  1 2  2 3  3 4  4 5  5 6  ... j-1 j
                if(arr[j]<arr[j-1]){
                    switchNum(arr,j,j-1);
                }
            }
        }
        System.out.println("冒泡排序后："+Arrays.toString(arr));
    }

    //插入排序（后一个数字与前面排好序的数组进行从后往前逐个对比，如果比前一个数字小，那么交换位置 ，直到数字比前一个大或者前一个没有数字
    public static void insertSort(Integer[] N){
        //0   1   2   3   4   5
        //5   6   9   7   2   1
        //0位置和1位置对比进行排序，以此类推
        System.out.println(Arrays.toString(N));
        for(int i = 0;i<N.length;i++){
            //0到i-1为已经排好序的数组
            for(int j = 0;j<i ;j++){
                if(N[i]<N[j]){
                    switchNum(N,i,j);
                }
            }
        }
        System.out.println("插入排序后："+Arrays.toString(N));
    }

    //插入排序（后一个数字与前面排好序的数组进行从后往前逐个对比，如果比前一个数字小，那么交换位置 ，直到数字比前一个大或者前一个没有数字
    public static void insertSort1(Integer[] N){
        //0   1   2   3   4   5
        //5   6   9   7   2   1
        //0位置和1位置对比进行排序，以此类推
        System.out.println(Arrays.toString(N));
        for(int i = 1;i<N.length;i++){
            //0到i-1为已经排好序的数组
            while (i - 1 >= 0 && N[i]< N[i-1]){
                switchNum(N,i,i-1);
                i--;
            }
        }
        System.out.println("插入排序后："+Arrays.toString(N));
    }

    private static void switchNum(Integer[] N,int i,int j){
        int now = N[i];
        N[i] = N[j];
        N[j] = now;
    }

    public static void main(String[] args) {
        Integer[] N  = {6,5,6,8,9,4,2,8,4,0};
        SelectionSort(N);
        Integer[] N1 = {6,5,6,8,9,4,2,8,4,0};
        bubbleSort(N1);
        Integer[] N2 = {6,5,6,8,9,4,2,8,4,0};
        insertSort(N2);
        Integer[] N3 = {6,5,6,8,9,4,2,8,4,0};
        insertSort1(N3);
    }
    /**输出为
     * [6, 5, 6, 8, 9, 4, 2, 8, 4, 0]
     * 选择排序后：[0, 2, 4, 4, 5, 6, 6, 8, 8, 9]
     * [6, 5, 6, 8, 9, 4, 2, 8, 4, 0]
     * 冒泡排序后：[0, 2, 4, 4, 5, 6, 6, 8, 8, 9]
     * [6, 5, 6, 8, 9, 4, 2, 8, 4, 0]
     * 插入排序后：[0, 2, 4, 4, 5, 6, 6, 8, 8, 9]
     * [6, 5, 6, 8, 9, 4, 2, 8, 4, 0]
     * 插入排序后：[0, 2, 4, 4, 5, 6, 6, 8, 8, 9]
     */
}
