package offer;

import java.util.Arrays;

/**
 * 寻找一个整数的全排列数的下一个数
 * 尽量保持高位不变，地位在最小的范围内变换顺序
 * 时间复杂度为O(n)
 */
public class findNearestNumber {
    //1.从后向前查看逆序区域，找到逆序区域的前一-位，也就是数字置换的边界
    public static int[] findNearestNumber(int[] numbers){
        int index = findTransferPoint(numbers);
        //如果数字置换边界是0，说明整个数组已经逆序，无法得到更大的相同数
        //字组成的整数，返回null
        if (index == 0){
            return null;
        }
        //2.把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
        //复制并入参，避免直接修改入参m
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        exchangeHead(numbersCopy,index);
        //3. 把原来的逆序区域改回顺序
        reverse(numbersCopy, index);
        return numbersCopy;
    }

    private static int[] reverse(int[] num, int index) {
        for (int i = index, j=num.length-1; i <j ; i++,j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return num;
    }

    private static int[] exchangeHead(int[] numbers, int index) {
        int head = numbers[index-1];
        for (int i= numbers.length-1; i>0; i--){
            if (head < numbers[i]){
                numbers[index-1]=numbers[i];
                numbers[i]=head;
                break;
            }
        }
        return numbers;
    }


    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length-1; i >0 ; i--) {
            if (numbers[i] > numbers[i-1]){
                return i;
            }
        }
        return 0;
    }
    //输出数组
    public static void main(String[] args) {
        int[] numbers = {1, 2, 5, 8, 3, 6};
        System.out.println(Arrays.toString(findNearestNumber(numbers)));
    }
}
