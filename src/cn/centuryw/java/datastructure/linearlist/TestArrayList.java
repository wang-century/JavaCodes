package cn.centuryw.java.datastructure.linearlist;

public class TestArrayList {
    public static void main(String[] args) {
        // 测试
        ArrayList list = new ArrayList();
        // 添加元素
        list.add(123);
        list.add(12);
        list.add(13);
        list.add(121);
        list.add(1, 111);
        list.remove((Object) 12);
        list.remove(0);
        list.addBefore(13, 111);
        list.addAfter(11, 121);
        list.replace(0, 14);
        // 打印属性
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.contains(13));
        System.out.println(list.get(1));
        System.out.println(list);
    }
}
