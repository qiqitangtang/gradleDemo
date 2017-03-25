package com.roobo.demo.dataStructuresAlgorithms.list;

import java.util.HashMap;
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
        Node root = new Node(1,null);
        Node left9 = new Node(10,root);
        Node left8  = new Node(9,left9);
        Node left7  = new Node(8,left8);
        Node left6  = new Node(7,left7);
        Node left5  = new Node(6,left6);
        Node left4  = new Node(5,left5);
        Node left3  = new Node(4,left4);
        Node left2  = new Node(3,left3);
        Node left1  = new Node(2,left2);
        root.setNext(left1);
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
    public static Node reGetMiddleNode(Node head){
        Node p1 = head,p2 = head;
        while(p2.getNext() != null){
            p1 = p1.getNext();
            p2 = p2.getNext();
            if (p2.getNext() != null) {
                p2 = p2.getNext();
            }
        }
        System.out.println("链表中间节点为：" + p1.getValue());
        return p1;
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
    public static Node mergeSortedList(Node head1,Node head2){
        if (head1 == null) printList(head2);
        if (head2 == null) printList(head1);
        Node mergeHead = null;
        if(head1.getValue() <= head2.getValue()){
          mergeHead = head1;
          head1 = head1.getNext();
        }else{
          mergeHead = head2;
          head2 = head2.getNext();
        }
        mergeHead.setNext(null);
        Node temp = mergeHead;
        while(head1 != null && head2 != null){
            if(head1.getValue() <= head2.getValue()){
                temp.setNext(head1);
                head1 = head1.getNext();

            }else{
                temp.setNext(head2);
                head2 = head2.getNext();
            }
            temp = temp.getNext();
            temp.setNext(null);
        }
        if(head1 != null){
            temp.setNext(head1);
        }
        if(head2 != null){
            temp.setNext(head2);
        }

        //printList(mergeHead);
        return mergeHead;
    }

    /**
     * 合并两个有序的单链表head1和head2，递归
     * @param head1,head2
     */
    public static Node mergeSortedListRec(Node head1,Node head2){
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        Node mergeHead = null;
        if(head1.getValue() > head2.getValue()){
            mergeHead = head2;
            mergeHead.setNext(mergeSortedListRec(head1,head2.getNext()));
        }else{
            mergeHead = head1;
            mergeHead.setNext(mergeSortedListRec(head1.getNext(),head2));
        }
        return mergeHead;
    }

    /**
     * 对单链表进行排序 归并
     * @param head
     */
    public static Node listSort(Node head){
        Node next = null;
        if(head == null || head.getNext() == null) return head;
        else if (head.getNext().getNext() == null){
            next = head.getNext();
            head.setNext(null);
        }else{
            Node mid = reGetMiddleNode(head);
            next = mid.getNext();
            mid.setNext(null);
        }
        return mergeSortedList(listSort(head),listSort(next));
    }

    /**
     * 对单链表进行排序 插入
     * @param head
     */
    public static Node insertionSortList(Node head){
        return null;
    }

    /**
     * 判断链表中是否有环：一个指针是另一个指针的2倍，相遇即有环
     * @param head
     */
    public static void hasCycle(Node head){
        boolean isHasCycle = false;
        Node p1 = head;
        Node p2 = head;
        while (p1 != null && p2 != null){
            p1 = p1.getNext();
            p2 = p2.getNext().getNext();
            if(p1 == p2){
                isHasCycle = true;
                break;
            }
        }
        System.out.println("链表中是否有环:" + isHasCycle);
    }

    /**
     * 判断两个单链表是否相交,如果相交返回第一个节点，否则返回null
     * 如果单纯的判断是否相交，只需要看最后一个指针是否相等
     * @param head1,head2
     */
    public static Node isIntersect(Node head1,Node head2){
        Node lastNode = null;
        boolean isIntersect = false;
        if(head1 == null || head2 == null ) return lastNode;
        int len1 = getListLength(head1);
        int len2 = getListLength(head2);
        if(len1 >= len2){
            for(int i=0 ;i<len1-len2;i++){
                head1 = head1.getNext();
            }
        }else{
            for(int i=0 ;i<len2-len1;i++){
                head2 = head2.getNext();
            }
        }

        while(head1 != null && head2 != null){
            if(head1 == head2){
                lastNode = head1;
                isIntersect = true;
                break;
            }else{
                head1 = head1.getNext();
                head2 = head2.getNext();
            }
        }

        if(isIntersect){
            System.out.println("两个链表相交的第一个节点为：" + lastNode.getValue());
        }
        return lastNode;
    }

    /**
     * 判断是否有环，求进入环的第一个节点 hashmap 去重复，第一个重复 的就是
     * @param head
     * @return
     */
    public static Node getFirstNodeInCycleHashMap(Node head){
        HashMap<Node,Boolean> map = new HashMap<Node,Boolean>();
        Node target = null;
        while (head != null){
            if(map.containsKey(head)) {
                target = head;
                break;
            }else{
                map.put(head,true);
            }
            head = head.getNext();
        }
        return target;
    }

    /**
     * 用快慢指针，与判断一个单链表中是否有环一样，
     * 找到快慢指针第一次相交的节点，此时这个节点距离环开始节点的长度和链表投距离环开始的节点的长度相等
     * @param head
     * @return
     */
    public static Node getFirstNodeInCycle(Node head){
        Node fast=head,slow = head;
        while(fast != null && slow != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.getNext() == null) return null;//判断是否有环
        //相遇节点距离环开始节点的长度和链表投距离环开始的节点的长度相等
        slow=head;
        while(slow!=fast){
            slow=slow.getNext();
            fast=fast.getNext();
        }//同步走
        return slow;

    }

    /**
     * 删除delete节点，时间复杂度O(1)
     * @param head
     * @param delete
     * 可采用将delete节点value值与它下个节点的值互换的方法，但是如果delete是最后一个节点，
     * 则不行，但是总得复杂度还是O(1)
     */
    public static void deleteNode(Node head,Node delete){
        if(delete == null) return;
        if(delete.getNext() == null){
            if(head == delete ) head = null;
            else{
                Node tmp = head;
                while(tmp.getNext() != delete){
                    tmp = tmp.getNext();
                }
                tmp.setNext(null);
            }
        }else{
            delete.setValue(delete.getNext().getValue());
            delete.setNext(delete.getNext().getNext());
        }
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

//        Node left7  = new Node(8,null);
//        Node left4  = new Node(5,left7);
//        Node left3  = new Node(4,left4);
//        Node head1 = new Node(1,left3);
//
//        Node left9 = new Node(10,null);
//        Node left8  = new Node(9,left7);
//        Node left6  = new Node(7,left8);
//        Node left5  = new Node(6,left6);
//        Node left2  = new Node(3,left5);
//        Node head2  = new Node(2,left2);
        //mergeSortedList(head1,head2);
        //printList(mergeSortedListRec(head1,head2));

        Node left8  = new Node(9,null);
        Node left9 = new Node(10,left8);
        Node left2  = new Node(3,left9);
        Node left1  = new Node(2,left2);
        Node left3  = new Node(4,left1);
        Node left4  = new Node(5,left3);
        Node left5  = new Node(6,left4);
        Node left7  = new Node(8,left5);
        Node left6  = new Node(7,left7);
        Node head  = new Node(1,left6);
//        printList(head);
        //printList(listSort(head));
        //printList(insertionSortList(head));
        //hasCycle(head);
        //
        // isIntersect(head1,head2);
        //System.out.println(getFirstNodeInCycleHashMap(head).getValue());
        printList(head);
        deleteNode(head,left9);
        printList(head);
    }


}
