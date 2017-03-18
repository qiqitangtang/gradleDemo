package com.roobo.demo.dataStructuresAlgorithms.list;

/**
 * Created by NOTE-026 on 2017/3/17/0017.
 */
public class Node {
    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
