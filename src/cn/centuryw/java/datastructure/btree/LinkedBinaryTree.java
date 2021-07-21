package cn.centuryw.java.datastructure.btree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedBinaryTree implements BinaryTree {
    Node root;  // 根节点

    public LinkedBinaryTree() {
    }

    public LinkedBinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return this.size(root);
    }

    private int size(Node root) {
        if (root != null) {
            // 获取左子树的高度
            int nl = this.size(root.leftChild);
            // 获取右子树的高度
            int nr = this.size(root.rightChild);
            // 返回左子树、右子树之和并+1
            return nl + nr + 1;
        } else {
            return 0;
        }
    }

    @Override
    public int getHeight() {
        return this.getHeight(root);
    }

    private int getHeight(Node root) {
        if (root != null) {
            // 获取左子树的高度
            int nl = this.getHeight(root.leftChild);
            // 获取右子树的高度
            int nr = this.getHeight(root.rightChild);
            // 返回左子树、右子树中较大的数并+1
            return nl > nr ? nl + 1 : nr + 1;
        } else {
            return 0;
        }
    }

    @Override
    public Node findKey(Object value) {
        return this.findKey(value, root);
    }

    public Node findKey(Object value, Node root) {
        if (root == null) { // 如果是空节点返回null
            return null;
        } else if (root.data == value) {    // 如果不是空节点并且当前节点的值等于要查找的值, 返回当前节点
            return root;
        } else {
            // 递归进行查找，找左右子树
            Node node1 = this.findKey(value, root.leftChild);
            Node node2 = this.findKey(value, root.rightChild);
            // 判断左右子书的值是否为要查找的值, 是则返回节点，否则返回null
            if (node1 != null && node1.data == value) {
                return node1;
            } else if (node2 != null && node2.data == value) {
                return node2;
            } else {
                return null;
            }
        }
    }

    @Override
    public void preOrderTraverse() {
        if (root != null) {
            // 输出根节点的值
            System.out.print(root.data + "\t");
            // 对左子树进行先序遍历
            BinaryTree leftTree = new LinkedBinaryTree(this.root.leftChild);
            leftTree.preOrderTraverse();
            // 对右子树进行先序遍历
            BinaryTree rightTree = new LinkedBinaryTree(this.root.rightChild);
            rightTree.preOrderTraverse();
        }
    }

    @Override
    public void inOrderTraverse() {
        this.inOrderTraverse(root);
        System.out.println();
    }

    public void inOrderTraverse(Node root) {
        if (root != null) {
            // 遍历左子树
            this.inOrderTraverse(root.leftChild);
            // 输出根的值
            System.out.print(root.data + "\t");
            // 遍历右子树
            this.inOrderTraverse(root.rightChild);
        }
    }

    @Override
    public void postOrderTraverse() {
        this.postOrderTraverse(root);
        System.out.println();
    }

    public void postOrderTraverse(Node root) {
        if (root != null) {
            // 遍历左子树
            this.postOrderTraverse(root.leftChild);
            // 遍历右子树
            this.postOrderTraverse(root.rightChild);
            // 输出根的值
            System.out.print(root.data + "\t");
        }
    }

    @Override
    public void inOrderByStack() {
        // 创建栈
        Deque<Node> stack = new LinkedList<>();
        Node current = root;
        while (current != null || !stack.isEmpty()){
            while (current!=null){
                stack.push(current);
                current = current.leftChild;
            }
            if (!stack.isEmpty()){
                current = stack.pop();
                System.out.print(current.data+" ");
                current = current.rightChild;
            }
        }
        System.out.println();
    }

    @Override
    public void preOrderByStack() {

    }

    @Override
    public void postOrderByStack() {

    }

    @Override
    public void levelOrderByStack() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node temp = queue.poll();
                assert temp != null;
                System.out.print(temp.data + " ");
                if (temp.leftChild != null) {
                    queue.add(temp.leftChild);
                }
                if (temp.rightChild != null) {
                    queue.add(temp.rightChild);
                }
            }
        }
        System.out.println();
    }
}
