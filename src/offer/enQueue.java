package offer;

import java.util.Stack;

/**
 * 用栈模拟一个队列，要求实现队列的两个基本操作，入队出队
 */
public class enQueue {
    private Stack<Integer> stackA = new Stack<Integer>();
    private Stack<Integer> stackB = new Stack<Integer>();

    /**
     * 入队操作
     * @param element 入队的元素
     */
    public void enQueue1(int element){
        stackA.push(element);
    }

    /**
     * 出队操作
     * @return 出队元素
     */
    public Integer deQueue(){
        if(stackB.isEmpty()){
            if (stackA.isEmpty())
                return null;
            transfer();
        }
        return stackB.pop();
    }

    /**
     * 将A中的元素转移到B
     */
    private void transfer() {
        while (!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) throws Exception{
        enQueue stackQueue = new enQueue();
        stackQueue.enQueue1(1);
        stackQueue.enQueue1(2);
        stackQueue.enQueue1(3);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        stackQueue.enQueue1(4);
        System.out.println(stackQueue.deQueue());
    }
}
