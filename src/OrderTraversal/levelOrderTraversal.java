package OrderTraversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class levelOrderTraversal {
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
    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null){
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null){
                queue.offer(node.rightChild);
            }
        }
    }
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
                Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null,
                        8, null, 4}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("广度优先遍历");
        levelOrderTraversal(treeNode);
    }

}
