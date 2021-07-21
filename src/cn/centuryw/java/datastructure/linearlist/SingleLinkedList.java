package cn.centuryw.java.datastructure.linearlist;

/**
 * 单链表
 *
 * @author centuryw
 */
class Node {
    Object data;    // 存储的数据
    Node next;      // 下一个节点

    public Node() {
        this.next = null;
    }

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class SingleLinkedList implements List {
    private Node head;  // 头节点
    private int size;   // 节点个数


    public SingleLinkedList() {
        this.head = new Node();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        // 判断索引是否正确
        confirmIndex(i);
        Node temp = head;
        for (int j = 0; j <= i; j++) {
            temp = temp.next;
        }
        return temp.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        return indexOf(e) != -1;
    }

    @Override
    public int indexOf(Object e) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.next.data == e) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public void add(int index, Object e) {
        Node node = new Node(e);
        // 判断索引是否正确
        confirmIndex(index);
        Node temp = head;
        // 通过循环到达指定位置节点
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        // 将节点插入
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public void confirmIndex(int index) {
        // 判断索引是否正确
        if (index < 0 || index > size) {
            throw new RuntimeException("数组索引越界!");
        }
    }

    @Override
    public void add(Object e) {
        Node node = new Node(e);
        // 链表为空则头节点指向插入的节点
        if (head.next == null) {
            head.next = node;
        } else {
            // 将最后节点的下一个节点设为插入的节点
            Node temp = head;
            for (int i = 0; i < size; i++) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++; // 节点个数+1
    }

    @Override
    public boolean addBefore(Object e, Object before) {
        // 判断是否有该元素
        int index = indexOf(before);
        if (index != -1) {
            add(index, e);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAfter(Object e, Object after) {
        // 判断是否有该元素
        int index = indexOf(after);
        if (index != -1) {
            add(index + 1, e);
            return true;
        }
        return false;
    }

    @Override
    public Object remove(int index) {
        confirmIndex(index);    // 判断索引是否正确
        Node temp = head;
        // 通过循环到达指定位置节点
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Object oldElement = temp.next.next.data;
        // 将节点删除
        temp.next = temp.next.next;
        size--;
        return oldElement;
    }

    @Override
    public boolean remove(Object e) {
        // 判断是否有该元素
        int index = indexOf(e);
        if (index != -1) {
            remove((int) index);
            return true;
        }
        return false;
    }

    @Override
    public Object replace(int index, Object e) {
        confirmIndex(index);    // 判断索引是否正确
        Node temp = head;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        Object oldElement = temp.data;
        temp.data = e;
        return oldElement;
    }


    @Override
    public String toString() {
        Node temp = head;
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                stringBuilder.append(temp.next.data).append(",");
            } else {
                stringBuilder.append(temp.next.data);
            }
            temp = temp.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
