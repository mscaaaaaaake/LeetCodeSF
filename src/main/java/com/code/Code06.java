package com.code;

public class Code06 {

    public static void print(int num){
        for (int i = 31;i>=0;i--) {
            System.out.print((num&(1<<i))==0?"0":"1");
            //看起来就是输入项num跟1的左移数对比，如果是一样的说明这个位置上有1，则可以打印出来任何数字底层的int型32位数字;
            // &的逻辑，1&1==1;1&0==0;0&1==0;0&0==0
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Integer型底层32位
        //整型的32位字符产生规律：逢1进1，即从1开始，往左边移数字，
        // 1位最右边数字为1其他为0,
        //00000000000000000000000000000001
        // 2进来的时候最右为1，那么就是把这个1左移一位，个位数归0,
        //00000000000000000000000000000010
        // 3进来的时候最右为0，不用进，则继续往最右加一个1，以此类推
        //00000000000000000000000000000011

        System.out.println("------------左移知识点----------");
        print(8);
        print(8<<2);//一个数的左移结果都等于这个数据乘以2的座位位数次方 底层数字展示为：2ⁿ(n=31) 2ⁿ(n=30) 2ⁿ(n=29) ... 2ⁿ(n=3) 2ⁿ(n=2) 2ⁿ(n=1) 2ⁿ(n=0)
        //8左移2位应该为 8*(2的二次方)
        print(32);
        System.out.println("------------位移运算符号----------");
        print(123);
        print(321);
        System.out.println("=========\"&\":");
        print(123&321);//与 同为1则为1，否则为0
        System.out.println("=========\"|\":");
        print(123|321);//其中有一个为1则为1，或者可以说是同为0则为0
        System.out.println("=========\"^\":");
        print(123^321);//相同则为1，否则为0，同为1或同为0显示为1
        System.out.println("-------------正负数的二进制转换---------");
        //整型integer是一个有符号的数字类型，即正和负。
        // 取反字符为~，取反的意义就是0取反为1,1取反为0
        // 而在二进制中：
        // 正数表示为除了最左边一位只能是0，其他31位皆可为1，最大值为2的31次方减1（因为0被归为正数方），所以32位全是0时占一个数字。
        // 负数表示为除了最左边一位只能是1，其他31为皆可为0，且负数与正数的二进制结果除了最左一位以外，其他位置的数字为取反，最小值为负2的31次方（由于0被归为正数，所以负值的最小值可以达到2的31次方
        // 但是这里要注意，由于0占了一个正数位，所以一个数的正负数整型并不会是真正意义上的取反，而是:负数的正数型的二进制是去掉最左边的1，其他位数取反，再需要减一；正数的负数型的二进制是最左边位置改为1，其他位置取反以后再加一。
        print(23);
        print(-24);
        print(-23);
        System.out.println("--------------右移知识点---------");
        //>>和>>>的区别
        //>>为带符号右移 >>>为不带符号右移
        //>>右移一位以后最左需要补位，那么就是看该整型是正数还是负数，正数则补0，负数则补1
        print(1024);
        System.out.println("带符号右移：");
        print(1024>>2);
        System.out.println("不带符号右移：");
        print(1024>>>2);
        System.out.println("带符号右移：");
        print(-1024>>2);
        System.out.println("不带符号右移：");
        print(-1024>>>2);

    }
    /**
     * 输出为：
     * 00000000000000000000000000001000
     * 00000000000000000000000000100000
     * 00000000000000000000000000100000
     * ----------------------
     * 00000000000000000000000001111011
     * 00000000000000000000000101000001
     * ========="&":
     * 00000000000000000000000001000001
     * ========="|":
     * 00000000000000000000000101111011
     * ========="^":
     * 00000000000000000000000100111010
     *
     * Process finished with exit code 0
     */
}
