package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class bucketSort {
    public static double[] bucketSort(double[] array){
        double max = array[0];
        double min = array[0];
        for (int i = 0; i < array.length ; i++) {
            if (array[i] > max){
                max = array[i];
            }
            if (array[i] < min){
                min = array[i];
            }
        }
        // 计算出最大最小差值d
        double d = max - min;

        //初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketLIst = new
                ArrayList<LinkedList<Double>>(bucketNum);
        for (int i = 0; i < bucketNum ; i++) {
            bucketLIst.add(new LinkedList<Double>());
        }
        // 遍历原始数组，将每个元素放入桶中
        for (int i = 0; i < array.length ; i++) {
            int num = (int)((array[i] - min) * (bucketNum-1) / d);
            bucketLIst.get(num).add(array[i]);
        }
        // 对每个桶内部进行排序
        for (int i = 0; i < bucketLIst.size() ; i++) {
            Collections.sort(bucketLIst.get(i));
        }
        // 输出全部元素
        double [] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketLIst) {
            for (double element : list){
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        double[] array = new double[]
                {4.12,6.421,0.0023,3.0,2.123,8.122,4.12, 10.09};
        double[] sortedArray =bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
