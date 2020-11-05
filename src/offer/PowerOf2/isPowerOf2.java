package offer.PowerOf2;

/**
 * 判断一个数字是不是2的倍数
 */
public class isPowerOf2 {

//    public static boolean isPowerOf2(int num){
//        int tmp = 1;
//        while (tmp <= num){
//            if (tmp == num){
//                return true;
//            }
//            //tmp = tmp * 2;
//            //用移位运算表示
//            tmp = tmp<<1;
//        }
//        return false;
//    }

    /**
     *  引入按位计算的方法，得出只要n&(n-1)为零的话，那么这个数就一定为2的次幂
     * @param num
     * @return
     */
    public static boolean isPowerOf2(int num){
        return (num&(num-1))==0;
    }
    public static void main(String[] args) {
        System.out.println(isPowerOf2(32));
        System.out.println(isPowerOf2(100));
    }
}
