//三种遍历方法
package tree;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTree {
    /*
    构建二叉树
    */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()){
            return null;
        }
        Integer data = inputList.removeFirst();
        if(data != null){
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 前序遍历
     */
    public static void preOrderTraveral(TreeNode node){
        if (node == null)
            return;
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 中序遍历
     */
    public static void inOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    /**
     * 后序遍历
     */
    public static void postOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 二叉树节点
     */
    private static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(
                Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null,null,
                8, null, 4}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历");
        preOrderTraveral(treeNode);
        System.out.println("中序遍历");
        inOrderTraveral(treeNode);
        System.out.println("后序遍历");
        postOrderTraveral(treeNode);
    }

}
