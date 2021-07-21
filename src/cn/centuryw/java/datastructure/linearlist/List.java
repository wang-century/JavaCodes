package cn.centuryw.java.datastructure.linearlist;

/**
 * 线性表的接口
 *
 * @author centuryw
 */
public interface List {
    int size();          // 线性表大小(元素个数)

    Object get(int i);   // 返回表中序号为i的元素

    boolean isEmpty();   // 表是否为空

    boolean contains(Object e);  // 表中是否含有指定元素

    int indexOf(Object e);       // 元素在表中的位置索引

    void add(int index, Object e);    // 将元素插入表中指定位置

    void add(Object e);          // 将元素插入到表末尾

    boolean addBefore(Object e, Object before);  // 将元素插入到指定元素前

    boolean addAfter(Object e, Object after);    // 将元素插入到指定元素后

    Object remove(int index);      // 删除表中指定索引元素并返回元素

    boolean remove(Object e);   // 删除表中找到的第一个指定元素

    Object replace(int index, Object e); // 替换表中索引i位置的元素为e并返回原数据

}
