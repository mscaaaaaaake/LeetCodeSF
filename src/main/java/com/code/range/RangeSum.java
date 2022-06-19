package com.code.range;



public class RangeSum {

    //需求：有一个数组int[] N = {3,5,1,6,-1,8,-5,5,6,4,65,32,-5,7}，求它的i位置到j位置数据的总和

    //方法一：
    //创建矩阵
    //预设一个矩阵，填写它所有区间的数据总和
//                0        1            2              3           4          ...          i
//        0       N[0]    N[0]+N[1]   N[0]+N[1]+N[2]  ....                                N[0]+...+N[i]
//
//        1       x       N[1]        N[1]+N[2]    N[1]+N[2]+N[3]                         N[1]+...+N[i]
//
//        2       x       x               N[2]     N[2]+N[3]                              N[2]+...+N[i]
//
//        3       x       x               x           N[3]                                N[3]+...+N[i]
//
//        4       x       x               x           x           N[4]                    N[4]+...+N[i]
//        (不存在1到0位置的说法因此该表下半部分无效无效)
//        ...     x       x               x           x           x           ...
//
//        i       x       x               x           x           x           ...         N[i]
    //那么在拿i到j位置的总和的时候，就是去这张表里查找对应的位置N{i,j}

    //方法二：
    //预设总和数组
//    int[] sumArr = {N[0],N[0]+N[1],N[0]+N[1]+N[2],N[0]+N[1]+N[2]+N[3],N[0]+N[1]+N[2]+N[3]+N[4],...,N[0]+...+N[i]};
    //那么在拿i到j位数据总和的时候
    //i位置前一个位置的数据总和是N[0]+...+N[i-1]
    //j位置的数据总和是N[0]+...+N[j]
    //i到j位置的数据总和就是( N[0]+...+N[j] ) - ( N[0]+...+N[i-1] )

    //显然第二种方法浪费的内存比较少，但是数据量庞大的时候，第一种方法比较迅速

    public static int preRange1(int[] arr,int i){
        //获取0到i位置的数据总和
        int sum = 0;
        for (int n = 0;n<i+1;n++) {
            sum += arr[n];
        }
        return sum;
    }

    public static int RangeSum1(int[] arr,int i,int j){
        if(i>j||j > arr.length-1){
            return 0;
        } else{
            return i == 0?preRange1(arr,j):preRange1(arr, j)-preRange1(arr, i - 1);
        }
    }

    public static class RangeSum2{
        static int[] preRange2;//预设的总和数组，填充该数组
        public RangeSum2(int[] arr){
            //计算0到i区间的总和
            int i = arr.length;
            preRange2 = new int[i];//分配空间不然会越位
            preRange2[0] = arr[0];
            for(int n = 1;n<i;n++){
                preRange2[n] = arr[n]+preRange2[n-1];//当前数组位置的数字加上对应的预设总和数组前一个位置的数字（之前的总和）
            }
        }

        public int RangeSum(int i,int j){
            return i==0?preRange2[0]:preRange2[j]-preRange2[i-1];
        }

    }


    public static void main(String[] args) {
        int[] N = {3,5,1,6,-1,8,-5,5,6,4,65,32,-5,7};
        //求2到4位置总和
        //自己写的
        System.out.println(RangeSum1(N,6,8));;
        //练习题写的
        RangeSum2 r = new RangeSum2(N);
        System.out.println(r.RangeSum(6,8));
    }

}
