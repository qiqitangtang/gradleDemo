package com.roobo.demo.dataStructuresAlgorithms.binaryTree;

/**
 * Created by NOTE-026 on 2017/3/13/0013.
 */
public class Node {
    private int value;
    private Node left;
    private Node right;
    private int visited;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.visited = 1;
    }

    public int getVisited() {
        return visited;
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
