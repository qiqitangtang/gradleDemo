package com.roobo.demo.dataStructuresAlgorithms.binaryTree;

import java.util.Stack;

/**
 * Created by NOTE-026 on 2017/3/13/0013.
 */
public class TreeNode {

    /**
     * 生成二叉树
     * @return
     */
    public static Node createTree(){
        Node left5 = new Node(10,null,null);
        Node left4  = new Node(8,null,null);
        Node right4  = new Node(9,left5,null);
        Node left3  = new Node(6,null,null);
        Node right3  = new Node(7,null,null);
        Node left2  = new Node(4,left4,right4);
        Node right2  = new Node(5,null,null);
        Node left1  = new Node(2,left2,right2);
        Node right1  = new Node(3,left3,right3);
        Node root = new Node(1,left1,right1);
        return root;
    }

    /**
     * 求二叉树节点个数
     * @param root
     * @return
     */
    public static int sumNodeNum(Node root){
        if(root == null) return 0;
        return 1 + sumNodeNum(root.getLeft()) + sumNodeNum(root.getRight());
    }

    /**
     * 求二叉树深度
     * @param root
     * @return
     */
    public static int nodeDeepth(Node root){
        if(root == null) return 0;
        return 1 + Math.max(nodeDeepth(root.getLeft()),nodeDeepth(root.getRight()));
    }

    /**
     * 前序遍历-递归
     * @param root
     */
    private static void perOrder(Node root){
        if(root == null) return;
        System.out.print(root.getValue() + " ");
        perOrder(root.getLeft());
        perOrder(root.getRight());

    }


    /**
     * 前序遍历-非递归
     * @param root
     */
    private static void preOrderNon(Node root){
        Stack<Node> stack = new Stack();
        Node n = root;//通过n来遍历节点
        while(n!=null || !stack.isEmpty()){
            //左子树全部入栈
            while(n != null){
                System.out.print(n.getValue() + " ");
                stack.push(n);
                n = n.getLeft();
            }
            //右子树入栈
            if(!stack.isEmpty()){
                n = stack.pop();
                n = n.getRight();
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历-递归
     * @param root
     */
    private static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrder(root.getRight());
    }

    /**
     * 中序遍历--非递归
     * @param root
     */
    private static void inOrderNon(Node root){
        Stack<Node> stack = new Stack<>();
        Node n = root ;
        while (n != null || !stack.isEmpty()){
            while (n != null){
                stack.push(n);
                n = n.getLeft();
            }
            if(!stack.isEmpty()){
                n = stack.pop();
                System.out.print(n.getValue() + " ");
                n = n.getRight();
            }
        }
        System.out.println();
    }

    /**
     * 后序遍历-递归
     * @param root
     */
    private static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue() + " ");
    }

    /**
     * 后序遍历--非递归
     * @param root
     */
    private static void postOrderNon(Node root){
        Stack<Node> stack = new Stack<>();
        Node n = root;
        while (n != null || !stack.isEmpty()) {
            while (n != null) {
                stack.push(n);
                n = n.getLeft();
            }

            if (!stack.isEmpty()) {
                n = stack.pop();
                if(n.getVisited() == 1){
                    n.setVisited(2);
                    stack.push(n);
                    n = n.getRight();
                }else{
                    System.out.print(n.getValue() + " ");
                    n = null;
                }
            }
        }
    }

    /**
     * 分层遍历
     * @param root
     */
    private static void levelOrder(Node root){

    }

    public static void main(String[] args) {
        Node root = createTree();
        //二叉树节点
        int nodeNum = sumNodeNum(root);
        System.out.println("二叉树的节点总数为：" + nodeNum);
        //二叉树深度
        int deepth = nodeDeepth(root);
        System.out.println("二叉树的深度为" + deepth);
        //前序遍历--递归
        perOrder(root);
        System.out.println();
        //前序遍历--非递归
        preOrderNon(root);
        //中序遍历
        inOrder(root);
        System.out.println();
        //中序遍历--非递归
        inOrderNon(root);
        //后序遍历
        postOrder(root);
        System.out.println();
        //后序遍历--非递归
        postOrderNon(root);

    }
}
