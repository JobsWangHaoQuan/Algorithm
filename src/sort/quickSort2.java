package sort;

import java.util.Arrays;

public class quickSort2 {
    public static void quickSort2(int[] arr, int startIndex, int endIndex){
        //递归结束条件：startIndex大于或等于endIndex时
        if (startIndex >= endIndex){
            return;
        }
        //得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        //根据基准元素，分成两部分进行递归排序
        quickSort2(arr, startIndex, pivotIndex-1);
        quickSort2(arr, pivotIndex+1, endIndex);
    }

    /**
     * 分治
     * @param arr  待交换的数组
     * @param startIndex  起始下标
     * @param endIndex  结束下标
     * @return
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        //取第一个位置（也可以选择随机位置）的元素作为基准元素
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex+1; i <=endIndex ; i++) {
            if (arr[i]<pivot){
                mark++;
                int p =arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        //pivot 和指针重合点交换
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,4,6,5,3,2,8,1};
        quickSort2(arr, 0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
