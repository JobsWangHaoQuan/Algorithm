package offer;

/**
 * 两种方法结合求出最大公约数，用到了移位运算 >> 意思是除2
 * 时间复杂度O(log(max(a, b)))
 */
public class gcd4 {
    public static int gcd4(int a, int b){
        if(a == b){
            return a;
        }
        if((a&1)==0 && (b&1)==0){
            return gcd4(a>>1, b>>1)<<1;
        }else if ((a&1)==0 && (b&1)!=0){
            return gcd4(a>>1, b);
        }else if ((a&1)!=0 && (a&1)==0){
            return gcd4(a, b>>1);
        }else {
            int big = a>b ? a:b;
            int small = a<b ? a:b;
            return gcd4(big-small, small);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd4(25,8));
        System.out.println(gcd4(100,8));
        System.out.println(gcd4(1365,45));
    }
}
