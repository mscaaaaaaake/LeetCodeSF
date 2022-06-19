package com.code.range;

public class Random {

    public static void randTest(double testRand){
        //验证等概率
        //设定一个总次数，将总次数中出现的一部分特定的数字区间的次数除以总次数，对比概率
        int sumTimes = 1000000;
        int count = 0;
        for (int i = 0;i<sumTimes;i++) {
            double randNum = Math.random();
            if(randNum < testRand){
                count++;
            }
        }
        double showRand = Double.valueOf(count)/Double.valueOf(sumTimes);
        System.out.println("出现的数字小于"+testRand +"的概率是:" + showRand);
    }

    public static void randIntTest(int K){
        int sumTimes = 1000000;
        int[] kCount = new int[K];
        for(int i = 0;i<sumTimes;i++){
            int N = (int) (Math.random()*K);//因为是1到K随机出现，那么验证也就是循环1到K
            kCount[N]++;
        }
        for (int i = 0;i<K;i++) {//循环1到K出现次数
            System.out.println(i+" 出现了 "+kCount[i]+" 次");
        }
    }

    public static double  xPower2(){
        //这部分原理需要思考，一只math.random得到的数字就是他出现的概率（上述验证可得）
        //math.max选出的数字 n 无论如何都是两个随机数据的最大值
        //那么拆开来看，假设max(x1,x2)，x1出现的数字是两者之间的最大值的概率为n1，x2出现的数字是两者之间的最大值的概率为n2
        //上述两者综合起来看，得到的max值 n 出现的概率就是 n1=n 出现的概率算上 n2=n 出现的概率 ，就是 n1*n2=n*n 为原math.random的平方
        return Math.max(Math.random(),Math.random());//max函数的意义就是两数返回最大值



    }

    public static double  xPower3(){
        //综合上述算平方的例子可以得到，算立方就是再加一个随机数组，得到三种情况下，同一个数字出现的概率
        return Math.max(Math.random(),Math.max(Math.random(),Math.random()));//max函数的意义就是两数返回最大值


    }

    public static double extraMath2(){
        //引申
        //如果用min算出来的是什么，那么思考如果是min落在两边区域的概率应该是什么
        //min获取的是两者之间的最小值，那么随便一个数都能满足
        //那么反向思考落在区间外的概率应该为x
        // （为什么要算作落在区间外，因为选择最小值也是只选择其中一个结果，获得落在区间外的概率可以看作两者只有一者满足，即排除大的那个数字的概率，计算该概率，落在区间内是无论什么情况下两者都能满足的），
        // 那么该数字落在小区间上的概率就是1-x,两者同时满足的话概率应该是(1-x)的平方，但是选择的是最小值，那么两者只要其中一个出现了就满足，那么就是出了两者都满足的情况以外的所有情况，即1-((1-x)的平方)
        return Math.min(Math.random(),Math.random());
    }
    public static void randPow(double x){
        //计算一个数字落在规定区间内的概率
        int count = 0;
        int times = 1000000;
        for(int i = 0;i<times;i++){
            if(xPower2()<x){
                //得到的结果落在该区间的概率
                count++;
            }
        }
        System.out.println("自写计算概率"+(double) count/(double) times);//经过计算的随机数落在规定的区域的概率 应该为该数字的平方
        System.out.println("函数计算概率"+Math.pow(x,2));
    }

    public static void randPow2(double x){
        //计算一个数字落在规定区间内的概率
        int count = 0;
        int times = 1000000;
        for(int i = 0;i<times;i++){
            if(xPower3()<x){
                //得到的结果落在该区间的概率
                count++;
            }
        }
        System.out.println("自写计算概率"+(double) count/(double) times);//经过计算的随机数落在规定的区域的概率 应该为该数字的立方
        System.out.println("函数计算概率"+Math.pow(x,3));
    }

    public static void extraMath(double x){
        //计算一个数字落在规定区间内的概率
        int count = 0;
        int times = 1000000;
        for(int i = 0;i<times;i++){
            if(extraMath2()<x){
                //得到的结果落在该区间的概率
                count++;
            }
        }
        System.out.println("自写计算概率"+(double) count/(double) times);//经过计算的随机数落在规定的区域的概率 应该为该数字的立方
        System.out.println("逻辑结论计算概率"+((double)1-(Math.pow((double)1-x,2))));
    }



    public static void main(String[] args) {
        //double rand = Math.random();//该随机数为一个0到1区间内小数的数组等概率返回的数字[0,1):大于等于0不等于1。
        randTest(0.6);
        System.out.println("===================================");
        randIntTest(7);
        System.out.println("===================================");
        randPow(0.2);
        randPow2(0.2);
        extraMath(0.2);

    }


    /**
     * 输出为
     * 出现的数字小于0.6的概率是:0.599926
     * ===================================
     * 0 出现了 142909 次
     * 1 出现了 142331 次
     * 2 出现了 143455 次
     * 3 出现了 143044 次
     * 4 出现了 143050 次
     * 5 出现了 142859 次
     * 6 出现了 142352 次
     * ===================================
     * 自写计算概率0.040182
     * 函数计算概率0.04000000000000001
     * 自写计算概率0.00787
     * 函数计算概率0.008000000000000002
     * 自写计算概率0.359636
     * 逻辑结论计算概率0.3599999999999999
     */
}
