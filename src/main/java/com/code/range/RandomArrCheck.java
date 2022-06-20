package com.code.range;

/**
 * 对数器
 * 释义：随机生成样本，对比数据测试数据是否有问题
 */
public class RandomArrCheck {

    //选择排序(将第一个数字与后面所有数字对比，小的放在第一个位置，以此类推，第二个数字也是相同做法
    private static int[] SelectionSort(int[] N){
        for (int i = 0;i<N.length;i++){
            //循环出数组里最小的数字
            int minI = i;//获取目前为止
            for(int j = i+1;j<N.length;j++) {//筛选目前为止至最后一个数区间最小值
                minI = N[j] < N[minI] ? j: minI;//两两对比遍历完全部数字发现最小值的位置
            }
            switchNum(N,i,minI);//将最小值和当前遍历至的位置的数字进行交换
        }
        return N;
    }


    //冒泡排序（相邻数字两两对比交换
    public static int[] bubbleSort(int[] arr){
        //对数组排序，谁大谁往后
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
        return arr;
    }

    //插入排序（后一个数字与前面排好序的数组进行从后往前逐个对比，如果比前一个数字小，那么交换位置 ，直到数字比前一个大或者前一个没有数字
    public static int[] insertSort(int[] N){
        //0   1   2   3   4   5
        //5   6   9   7   2   1
        //0位置和1位置对比进行排序，以此类推
        for(int i = 0;i<N.length;i++){
            //0到i-1为已经排好序的数组
            for(int j = 0;j<i ;j++){
                if(N[i]<N[j]){
                    switchNum(N,i,j);
                }
            }
        }
        return N;
    }

    //插入排序（后一个数字与前面排好序的数组进行从后往前逐个对比，如果比前一个数字小，那么交换位置 ，直到数字比前一个大或者前一个没有数字
    public static int[] insertSort1(int[] N){
        //0   1   2   3   4   5
        //5   6   9   7   2   1
        //0位置和1位置对比进行排序，以此类推
        for(int i = 1;i<N.length;i++){
            //0到i-1为已经排好序的数组
            while (i - 1 >= 0 && N[i]< N[i-1]){
                switchNum(N,i,i-1);
                i--;
            }
        }
        return N;
    }

    private static void switchNum(int[] N,int i,int j){
        int now = N[i];
        N[i] = N[j];
        N[j] = now;
    }

    /**
     * 规定范围内随机生成相关数列
     * @param maxLen 数列长度最大值
     * @param maxVal 数列最大值
     * @return 随机数列
     */
    public static int[] randRArr(int maxLen,int maxVal){
        //随机生成数列
        int[] randArr = new int[(int) (Math.random()*maxLen)];
        for (int i = 0; i < randArr.length; i++) {
            randArr[i] = (int)(Math.random()*maxVal);
        }
        return randArr;
    }

    /**
     * 检查是否为由小到大
     * @param arr 输入数列
     * @return 排序检测结果
     */
    public static boolean checkSort(int[] arr){
        if(arr.length<2){
            return false;
        }
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]){
                return true;
            }
        }
        return false;
    }

    public static int[] copyArr(int[] arr){
        int[] cArr = new int[arr.length];
        System.arraycopy(arr, 0, cArr, 0, arr.length);
        return cArr;
    }

    public static void main(String[] args) {
        //样本随机检查上述插入排序和冒泡排序是否正确
        int times = 10000;
        int maxLen = 10;
        int maxVal = 500;
        //循环times次检查随机生成的数列样本中是否有未排序的
        for (int i = 0; i < times; i++) {
            int[] newArr = randRArr(maxLen,maxVal);
            int[] bubbleArr = bubbleSort(copyArr(newArr));
            int[] selectArr = SelectionSort(copyArr(newArr));
            int[] insertArr = insertSort(copyArr(newArr));
            int[] insertArr1 = insertSort1(copyArr(newArr));
            if(checkSort(bubbleArr)){
                System.out.println("冒泡排序出错");
                break;
            } else if (checkSort(selectArr)) {
                System.out.println("选择排序出错");
                break;
            }else if (checkSort(insertArr)) {
                System.out.println("插入排序出错");
                break;
            }else if (checkSort(insertArr1)) {
                System.out.println("插入排序1出错");
                break;
            }
        }
        System.out.println("检测结束，未出现问题");
    }
    /*
      减少循环次数打印随机生成数组输出为
      []
      [399, 172, 88, 103, 318, 402]
      [36, 275, 83, 455]
      [90, 125, 44, 488, 7, 67, 255]
      [432, 36, 281, 316, 227]
      [305, 341, 94, 218, 62, 184]
      [106]
      []
      [343]
      [489, 198, 413, 295]
      [183, 162, 287, 164, 459, 290, 232, 58, 128]
      [338, 67, 26, 34, 496, 309, 203, 361]
      [389]
      [189, 360, 143, 448]
      [117, 494, 257, 278]
      []
      [173, 209, 121, 369, 455, 164, 413]
      [236, 328, 87, 0, 176, 222, 94]
      [436, 475]
      [259, 22, 195, 162, 353]
      [178, 414, 8, 258, 202, 250, 83, 206, 29]
      [245, 137, 27, 110, 364, 22, 5, 332]
      [411, 408, 477, 293, 337]
      [46, 359, 431, 209, 182, 84, 25, 194, 444]
      [376, 440, 76, 90, 285, 222, 465]
      [259, 244, 452, 162, 8, 298, 133]
      [9, 99, 277]
      [38, 105, 474, 437, 20, 72]
      [81, 276, 470]
      [229, 211, 137, 265, 124, 236]
      [224, 456, 253]
      [403, 161, 262]
      []
      [415, 246, 233, 381, 61, 261, 53, 235]
      []
      [394, 291, 438, 425]
      []
      [137, 209, 435, 244, 304, 21, 187, 419]
      [428, 183, 104, 173]
      [207, 461, 376, 377, 333, 49, 165, 194, 441]
      [429, 234, 246, 402, 233, 262]
      [336, 139, 211, 188, 290, 287]
      [190, 410, 356]
      [123, 332, 108, 262, 180, 473]
      [247, 297]
      [65, 484, 217]
      [488, 132, 476, 197, 291, 465, 278, 57, 201]
      [316, 342]
      [369]
      [132, 389]
      检测结束，未出现问题

      进程已结束,退出代码0
     */
}
