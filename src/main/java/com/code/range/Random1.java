package com.code.range;

public class Random1 {

    //需求：
    // 指定一个固定概率返回0和1，如何用新的方法函数处理为等概率返回

    /**
     * 固定概率为0.97返回0，0.09返回1
     */
    public static int X(){
        return Math.random() > 0.97?0:1;
    }
//解决-----------------------------------------------------
    /**
     * 自定义Y函数处理X返回值，筛选排除掉返回两次同为1或者0的组合，仅返回一次为0一次为1
     */
    public static int Y(){
        int num;
        do{
            num = X();
        }while (num == X());
        return num;
    }

    public static void main(String[] args) {
        //检查两者返回概率
        int times = 1000000;
        int count1 = 0;
        int count2 = 0;
        for (int i= 0;i<times;i++){
            if(X() == 0){
                count1++;
            }
            if(Y() == 0){
                count2++;
            }
        }
        System.out.println("X函数执行后出现0的概率是 "+ (double)count1/(double) times);
        System.out.println("Y函数执行后出现0的概率是 "+ (double)count2/(double) times);
    }

    /**
     * 输出为：
     * X函数执行后出现0的概率是 0.029911
     * Y函数执行后出现0的概率是 0.500114
     */
}
