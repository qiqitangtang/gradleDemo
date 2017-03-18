package com.roobo.demo.dataStructuresAlgorithms.list;

/**
 * Created by NOTE-026 on 2017/3/17/0017.
 */
public class SingleLinkedList {

    /**
     * 创建单链表
     * @return
     */
    public static Node createLinkedList(){
        Node left9 = new Node(10,null);
        Node left8  = new Node(9,left9);
        Node left7  = new Node(8,left8);
        Node left6  = new Node(7,left7);
        Node left5  = new Node(6,left6);
        Node left4  = new Node(5,left5);
        Node left3  = new Node(4,left4);
        Node left2  = new Node(3,left3);
        Node left1  = new Node(2,left2);
        Node root = new Node(1,left1);
        return root;
    }

    /**
     * 计算链表长度
     * @param head
     * @return
     */
    public static int getListLength(Node head){
        int length = 0;
        while(head != null) {
            head = head.getNext();
            length ++;
        }
        return length;
    }

    /**
     * 链表反转 非递归
     * @param head
     */
    public static void reverseList(Node head){



    }

    /**
     * 链表反转 递归
     * @param head
     */
    public static void reverseListRec(Node head){

    }

    public static void main(String[] args) {
        Node head = createLinkedList();
        int length = getListLength(head);
        System.out.println(length);
        reverseList(head);
    }


}
