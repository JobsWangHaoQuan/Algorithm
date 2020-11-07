package offer;

/**
 * 删除k可数字后得到最小值
 * 依次删除逆序数列的首元素
 * 依次求得局部最优解，最终得到全局最优解的思想叫做贪心算法
 * 时间复杂度O(kn)
 */
public class removeKDigitsV2 {
    /**
     * 删除整数的k个数字，获得删除后的最小值
     * @param num 原整数
     * @param k 删除数量
     * @return
     */
    public static String removeKDigitsV2(String num, int k) {
        //新整数的最终长度 = 原整数长度 -k
        int newLength = num.length() - k;
        //创建一个栈，用于接收所有的数字
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length() ; ++i) {
            //遍历当前数字
            char c = num.charAt(i);
            //当栈顶数字大于遍历到的当前数字时，栈顶数字出栈（相当于删除数字）
            while (top > 0 && stack[top -1] > c && k > 0){
                top -= 1;
                k -= 1;
            }
            //遍历到的当前数字入栈
            stack[top++] = c;continue;
        }
        //找到栈中第一个非0数字的位置，以此构建新的整数字符串
        int offset = 0;
        while (offset < newLength && stack[offset] == '0'){
            offset++;
        }
        return offset == newLength? "0" : new String(stack,
                offset, newLength - offset);
    }

    public static void main(String[] args) {
        System.out.println(removeKDigitsV2("52355325", 4));
        System.out.println(removeKDigitsV2("436543",2));
    }
}
