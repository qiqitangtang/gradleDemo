package com.roobo.demo.dataStructuresAlgorithms.binaryTree;

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
     * 前序遍历
     * @param root
     */
    private static void perOrder(Node root){
        if(root == null) return;
        System.out.print(root.getValue() + " ");
        perOrder(root.getLeft());
        perOrder(root.getRight());
    }

    /**
     * 中序遍历
     * @param root
     */
    private static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrder(root.getRight());
    }

    /**
     * 后续遍历
     * @param root
     */
    private static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue() + " ");
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
        //前序遍历
        perOrder(root);
        System.out.println();
        //中序遍历
        inOrder(root);
        System.out.println();
        //后序遍历
        postOrder(root);
    }
}
