package array;

public class arrayDelete {
    private int[] array;
    private int size;
    public arrayDelete(int capacity){
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
        //从右向左循环，将元素逐个向右挪1位
        for (int i = size-1; i >=index; i--) {
            array[i+1] = array[i];
        }
        //腾出的位置放新元素
        array[index] = element;
        size++;
    }

    /**
     * 输出数组
     */
    public void output(){
        for (int i = 0; i <size ; i++) {
            System.out.println(array[i]);
        }
    }
    public int delete(int index) throws Exception{
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("数组元素超出范围");
        }
        int deletedElement = array[index];
        for(int i=index; i<size-1; i++){
            array[i] = array[i+1];
        }
        size--;
        return deletedElement;
    }
    public static void main(String[] args) throws Exception{
        arrayDelete myarray = new arrayDelete(20);
        myarray.insert(3, 0);
        myarray.insert(5, 1);
        myarray.insert(9, 2);
        myarray.insert(5, 3);
        myarray.insert(6, 1);
        myarray.delete(2);
        myarray.output();
    }
}
