package array;

public class array2 {
    private int[] array;
    private int size;
    public array2(int capacity){
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 数组插入数据
     * @param element 插入的元素
     * @param  index  插入的位置
     */
    public void insert(int element, int index) {
        //判断是否超出范围
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("超出范围");
        }
        //判断元素个数是否达到上限，达到就扩容，调用数组扩容方法
        if (size >= array.length){
            resize();
        }
        //从右向左循环，将元素逐个向右挪1位
        for (int i = size-1; i >=index; i--) {
            array[i+1] = array[i];
        }
        //腾出的位置放新元素
        array[index] = element;
        size++;
    }

    //数组扩容
    private void resize() {
        int[] arrayNew = new int[array.length*2];
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    /**
     * 输出数组
     */
    public void output(){
        for (int i = 0; i <size ; i++) {
            System.out.println(array[i]);
        }
    }
    public static void main(String[] args) throws Exception{
        array2 myarray2 = new array2(4);
        myarray2.insert(3, 0);
        myarray2.insert(7, 1);
        myarray2.insert(9, 2);
        myarray2.insert(5, 3);
        myarray2.insert(6, 1);
        myarray2.output();
    }
}
