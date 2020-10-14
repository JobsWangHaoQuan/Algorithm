package sort;

import java.util.Arrays;

public class BubbleSort3 {
    public static void sort(int array[]){
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = array.length-1;
        for (int i = 0; i < array.length-1 ; i++) {
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder ; j++) {
                int temp = 0;
                if (array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    //因为有元素进行交换所以不是有序的，标记变为false
                    isSorted = false;
                    //更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted)
                break;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,8,6,3,9,2,1,7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
