package linkedList;

public class link {
    private Node head; //头结点指针
    private Node last;// 尾结点指针
    private int size;//链表实际长度

    //插入方法
    public void insert(int data, int index) throws Exception{
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node insertedNode = new Node(data);
        if(size == 0){
            //空链表
            head = insertedNode;
            last = insertedNode;
        }else if(index == 0){
            //插入头部
            insertedNode.next = head;
            head = insertedNode;
        }else if(size == index){
            //插入尾部
            last.next = insertedNode;
            last = insertedNode;
        }else {
            //中间插入
            Node prevNode = get(index-1);
            insertedNode.next = prevNode.next;
            prevNode.next = insertedNode;
        }
        size++;
    }

    public Node remove(int index) throws Exception{
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("超出范围");
        }
        Node removedNode = null;
        if (index == 0){
            //删除头结点
            removedNode = head;
            head = head.next;
        }else if(index == size-1){
            //删除尾结点
            Node preNode = get(index -1);
            removedNode = preNode.next;
            preNode.next = null;
            last = preNode;
        }else{
            //删除中间节点
            Node prevNode = get(index=1);
            Node nextNode = prevNode.next.next;
            removedNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removedNode;
    }
    //查找方法
    private Node get(int index) throws Exception{
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("超出范围");
        }
        Node temp = head;
        for(int i =0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }
    // 输出链表
    public void output(){
        Node temp = head;
        while (temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    //链表节点
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) throws Exception{
        link myLink = new link();
        myLink.insert(3,0);
        myLink.insert(7,1);
        myLink.insert(8,2);
        myLink.insert(5,3);
        myLink.insert(6,1);
        myLink.remove(0);
        myLink.output();

    }
}
