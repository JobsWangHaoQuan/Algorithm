package offer.gcd;

/**
 * 辗转相除法进行求最大公约数
 */
public class getGreatestCommonDivisorV2 {
    public static int getGreatestCommonDivisorV2(int a, int b){
        int big = a>b?a:b;
        int small = a<b?a:b;
        if(big%small == 0){
            return small;
        }
        return getGreatestCommonDivisorV2(big%small, small);
    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisorV2(25, 5));
        System.out.println(getGreatestCommonDivisorV2(25, 6));
        System.out.println(getGreatestCommonDivisorV2(27, 14));
    }
}
