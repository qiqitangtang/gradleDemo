package com.roobo.demo.dataStructuresAlgorithms.list;

import java.util.Stack;

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
     * 打印链表
     * @param head
     */
    public static void printList(Node head){
        while(head != null){
            System.out.print(head.getValue()+" ");
            head = head.getNext();
        }
        System.out.println();
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
        if(head == null || head.getNext() ==null) return;
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        printList(pre);
    }

    /**
     * 链表反转 递归
     * @param head
     */
    public static Node reverseListRec(Node head){
        if(head == null || head.getNext() ==null) return head;
        Node reHead = reverseListRec(head.next);
        head.next.next=head;
        head.next=null;
        return reHead;
    }

    /**
     * 获取倒数第K个值（执行此时为n+n-k）
     * @param head
     * @param k
     */
    public static void reGetKthNode(Node head,int k){
        if(head == null) return;
        int length = getListLength(head);
        if(k>length) return;
        int i = 0;
        while (i < (length-k)){
            head = head.getNext();
            i++;
        }
        System.out.println("reGetKthNode :倒数第"+k+"个节点的值为：" + head.getValue());
    }

    /**
     * 获取倒数第K个值（双指针）
     * @param head
     * @param k
     */
    public static void reGetKthNode2(Node head,int k){
        if(head == null || k == 0 || head.getNext() == null) return ;
        Node p1 = head;
        Node p2 = null;
        int i = 1;
        while(p1.getNext() != null){
            p1 = p1.getNext();
            if(p2 != null){
                p2 = p2.getNext();
            }
            if(i == k-1){
               p2 = head;
            }
            i++;

        }
        System.out.println("reGetKthNode2 :倒数第"+k+"个节点的值为：" + p2.getValue());
    }

    /**
     * 获取中间节点（两个指针，一个一次一个节点，一个一次两个节点）
     * @param head
     */
    public static void reGetMiddleNode(Node head){
        Node p1 = head,p2 = head;
        while(p2.getNext() != null){
            p1 = p1.getNext();
            p2 = p2.getNext();
            if (p2.getNext() != null) {
                p2 = p2.getNext();
            }
        }
        System.out.println("链表中间节点为：" + p1.getValue());
    }

    /**
     * 从尾到头打印单链表--非递归
     * @param head
     */
    public static void printListReverse(Node head){
        if(head == null ) return;
        Stack<Node> stack = new Stack();
        while (head != null){
            stack.push(head);
            head = head.getNext();
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop().getValue() + " ");
        }
    }

    /**
     * 从尾到头打印单链表--递归
     * @param head
     */
    public static void printListReverseRec(Node head){
        if(head == null ) return;
        if(head.getNext() != null){
            printListReverseRec(head.getNext());
        }
        System.out.print(head.getValue()+" ");
    }

    /**
     * 合并两个有序的单链表head1和head2，循环
     * @param head1,head2
     */
    public static void mergeSortedList(Node head1,Node head2){
        if(head1 == null || head2 == null ||head1.getNext() == null) return;
        while(head1.getNext() != null){
            if(head1.getValue() <= head2.getValue() && head2.getValue() < head1.getNext().getValue()){
                Node n = head2;
                head2 = n.getNext();
                n.setNext(head1.getNext());
                head1.setNext(n);
            }
            head1 = head1.getNext();
        }


    }

    /**
     * 合并两个有序的单链表head1和head2，递归
     * @param head1,head2
     */
    public static void mergeSortedListRec(Node head1,Node head2){

    }


    public static void main(String[] args) {
        //Node head = createLinkedList();
        //int length = getListLength(head);
        //System.out.println(length);
        //printList(head);
        //reverseList(head);
        //Node newHead = reverseListRec(head);
        //printList(newHead);
        //reGetKthNode(head,2);
        //reGetKthNode2(head,2);
        //reGetMiddleNode(head);
        //printListReverse(head);
        //printListReverseRec(head);

        Node left9 = new Node(10,null);
        Node left8  = new Node(9,left9);
        Node left7  = new Node(8,left8);
        Node left6  = new Node(7,left8);
        Node left5  = new Node(6,left6);
        Node left4  = new Node(5,left7);
        Node left3  = new Node(4,left4);
        Node left2  = new Node(3,left5);
        Node head2  = new Node(2,left2);
        Node head1 = new Node(1,left3);
        mergeSortedList(head1,head2);
        //mergeSortedListRec(head1,head2);
    }


}
