package offer;

/**
 * 用更相减损术求两个数的最大公约数
 */
public class getGreatestCommonDivisorV3 {
    public static int getGreatestCommonDivisorV3(int a, int b){
        if(a == b){
            return a;
        }
        int big = a>b ? a:b;
        int small = a<b ? a:b;
        return getGreatestCommonDivisorV3(big-small, small);
    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisorV3(25,5));
        System.out.println(getGreatestCommonDivisorV3(25,20));
        System.out.println(getGreatestCommonDivisorV3(40000,156));
    }
}
