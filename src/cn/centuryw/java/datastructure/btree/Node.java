package cn.centuryw.java.datastructure.btree;

/**
 * 二叉链表的节点
 * 包括左子树、右子树的引用
 * 以及数据值
 */
public class Node {
    Node leftChild;     // 左子树
    Node rightChild;    // 右子树
    Object data;        // 值


    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                ", data=" + data +
                '}';
    }
}