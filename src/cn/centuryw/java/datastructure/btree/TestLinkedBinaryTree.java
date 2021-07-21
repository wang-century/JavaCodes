package cn.centuryw.java.datastructure.btree;

/**
 * 测试链式存储二叉树
 */
public class TestLinkedBinaryTree {
    public static void main(String[] args) {
        // 创建节点, 设置左右关系
        Node node5 = new Node(5, null, null);
        Node node4 = new Node(4, null, node5);
        Node node7 = new Node(7, null, null);
        Node node6 = new Node(6, null, node7);
        Node node3 = new Node(3, null, null);
        Node node2 = new Node(2, node3, node6);
        Node node1 = new Node(1, node4, node2);
        // 创建一个二叉树, 设置根节点
        BinaryTree binaryTree = new LinkedBinaryTree(node1);
        // 判断二叉树是否为空
        System.out.println("二叉树是否为空?:"+binaryTree.isEmpty());
        // 先序遍历(递归)
        System.out.println("先序遍历:");
        binaryTree.preOrderTraverse();  // 1	4	5	2	3	6	7
        System.out.println();
        // 中序遍历(递归)
        System.out.println("中序遍历:");
        binaryTree.inOrderTraverse();   // 4	5	1	3	2	6	7
        // 后序遍历(递归)
        System.out.println("后序遍历:");
        binaryTree.postOrderTraverse(); // 5	4	3	7	6	2	1
        // 中序遍历(非递归, 借助栈)
        System.out.println("中序遍历(非递归):");
        binaryTree.inOrderByStack();
        // 按照层次遍历(借助队列)
        System.out.println("按层次遍历:");
        binaryTree.levelOrderByStack();
        // 查找某个值
        System.out.println("查找值2的结果:"+binaryTree.findKey(2));
        // 二叉树的高度
        System.out.println("树的高度:"+binaryTree.getHeight());
        // 二叉树的节点数
        System.out.println("二叉树节点个数:"+binaryTree.size());

    }
}
