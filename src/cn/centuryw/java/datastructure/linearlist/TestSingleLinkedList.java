package cn.centuryw.java.datastructure.linearlist;

public class TestSingleLinkedList {
    public static void main(String[] args) {
        List list = new SingleLinkedList();
        // 添加元素
        list.add(123);
        list.add(12);
        list.add(13);
        list.add(121);
        System.out.println(list);
        list.add(1, 111);
        list.add(0, 543);
        // 打印属性
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list);
        System.out.println(list.remove((int)0));
        System.out.println(list.indexOf(1211));
        System.out.println(list.replace(4,124));
        System.out.println(list);
        System.out.println(list.remove((Object) 12));
        System.out.println(list);
        System.out.println(list.get(1));
        list.addBefore(333,111);
        System.out.println(list);
        list.addAfter(131,124);
        System.out.println(list);
    }
}
