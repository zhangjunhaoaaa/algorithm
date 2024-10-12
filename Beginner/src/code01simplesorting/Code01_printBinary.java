package code01simplesorting;


/*打印2进制的int的数字*/
public class Code01_printBinary {

    //1.int 数字在计算机底层都是32位 2进制
    //2.1 << i  ： 1在32位二进制的数字位 00000000000000000000000000000001  ，一开始是向右移动31位，就是在第32位
    //3.num & (1 << i) ： 拿着1 从右开始往左边开始移动 ，是1打印就是1
    public static void print(int num ){
        for (int i = 31; i >= 0 ; i--) {
            System.out.print(( (num & (1 << i) )== 0 ? "0" : "1")  );
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //所有十进制的数字其实底层都是32位 2进制构成
        //int 是 32 ； long 是 64
        int num = 34235;//00000000000000001000010110111011
        print(num);

        intBinary();

    }


    //无符号整型 ： 0 ～ 2^32-1
    //有符号整型 ： -2^31 ～  2^31-1
    public static void intBinary(){
        int numMax = Integer.MAX_VALUE;
        print(numMax);//01111111111111111111111111111111
        int numMIn = Integer.MIN_VALUE;
        print(numMIn);//10000000000000000000000000000000
    }



}


