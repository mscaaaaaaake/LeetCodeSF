package com.code.Sort;

public class Code01 {

    private static void f1(int a){
        //计算传进来数字的阶乘（阶乘就是该数字乘以他之前所有数字，3的阶乘是3*2*1
        long nowNum = 1;
        long nowTotal = 0;
        for(int i = 1;i<=a;i++){
            //3! = 3*2*1 = 3*2!
            nowNum = nowNum*i;
            nowTotal = nowNum;
        }
        System.out.println(a+"!="+nowTotal);
    }


    public static void main(String[] args) {
        f1(5);
    }
    /**
     * 此处课件中关于阶乘的计算有错误，代码中已更正
     * 输出为
     * 5!=120
     */
}
