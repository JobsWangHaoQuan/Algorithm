package heap;

import java.util.Arrays;

public class Queue {
    private int[] array;
    private int size;
    public Queue(){
        //队列初始长度32
        array = new int[3];
    }
    /**
     * 入队
     * @param key 入队元素
     */
    public void enQueue(int key){
        //队列长度超出范围，扩容
        if (size >= array.length){
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    /**
     * 出队
     */
    public int deQueue() throws Exception{
        if (size <= 0){
            throw new Exception("the queue is empty!");
        }
        //获取堆顶元素
        int heah = array[0];
        //让最后一个元素移动到堆顶
        array[0] = array[--size];
        downAdjust();
        return heah;
    }

    /**
     * 下沉调整
     */
    private void downAdjust() {
        //temp保存插入的叶子节点值，用于最后的赋值
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;
        while (childIndex < size){
            //如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex+1 < size && array[childIndex+1]>
            array[childIndex]){
                childIndex++;
            }
            //如果父节点大于任何一个孩子的值，直接跳出
            if (temp >= array[childIndex])
                break;
            //无需真正的交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2*childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 上浮调整
     */
    private void upAdjust() {
        int childIndex = size-1;
        int parentIndex = (childIndex-1)/2;
        //temp保存插入的叶子节点值，用于最后的赋值
        int temp =array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]){
            //无需真正的交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = parentIndex/2;
        }
        array[childIndex] = temp;
    }

    /**
     * 队列扩容
     */
    private void resize() {
        //队列扩容至两倍
        int newsize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newsize);
    }

    public static void main(String[] args) throws Exception{
        Queue queue = new Queue();
        queue.enQueue(3);
        queue.enQueue(5);
        queue.enQueue(10);
        queue.enQueue(2);
        queue.enQueue(7);
        queue.enQueue(8);
        System.out.println("出队元素:"+queue.deQueue());
        System.out.println("出队元素:"+queue.deQueue());
        //出队的是最大值
    }
}
