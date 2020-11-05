package offer;

/**
 * 求数列中相邻两个数的最大差值
 * 用桶排序的方式是最好的方法，但是有点不好理解
 */
public class getMaxSortedDistance {
    public static int getMaxSortedDistance(int[] array){
        //1.得到数列的最大值与最小值
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length ; i++) {
            if (array[i] > max){
                max = array[i];
            }
            if (array[i] < min){
                min = array[i];
            }
        }
        int d = max - min;
        // 如果max 与min相等，则说明数列中所有制都相同，返回0
        if (d == 0){
            return 0;
        }
        //2. 初始化桶
        int bucketNum = array.length;
        Bucket [] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum ; i++) {
            buckets[i] = new Bucket();
        }
        //3.遍历原始数组，确定每个桶最大值和最小值
        for (int i = 0; i < array.length ; i++) {
            // 确定数组元素所归属的桶下标
            int index = ((array[i]-min) * (bucketNum - 1)/d);
            if (buckets[index].min == 0 || buckets[index].min>array[i]){
                buckets[index].min = array[i];
            }
            if (buckets[index].max == 0 || buckets[index].max<array[i]){
                buckets[index].max = array[i];
            }
        }
        //4.遍历桶，找到最大差值
        int maxDistance = 0;
        int leftMax = buckets[0].max;
        for (int i=1; i<buckets.length; i++){
            if (buckets[i].min == 0){
                continue;
            }
            if (buckets[i].min - leftMax > maxDistance){
                maxDistance = buckets[i].min -leftMax;
            }
            leftMax = buckets[i].max;
        }
        return maxDistance;
    }

    private static class Bucket {
        public int min;
        public int max;
    }

    public static void main(String[] args) {
        int[] array =  new int[] {2,6,3,4,5,10,9};
        System.out.println(getMaxSortedDistance(array));
    }
}
