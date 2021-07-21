package cn.centuryw.java.datastructure.linearlist;

/**
 * 顺序表
 * 说明：底层采用数组，长度可以动态变化
 *
 * @author centuryw
 */
public class ArrayList implements List {
    private Object[] elementData;   // 底层数组
    private int size;   // 元素个数

    /**
     * 无参构造函数，设置默认大小
     */
    public ArrayList() {
        elementData = new Object[4];   // 默认大小为4
        size = 0;
    }

    /**
     * 构造函数，设置数组初始长度
     *
     * @param initialCapacity 长度
     */
    public ArrayList(int initialCapacity) {
        // 给数组分配指定大小空间
        elementData = new Object[initialCapacity];
        // 设置表中元素个数
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i >= size) {
            throw new RuntimeException("数组索引越界!");
        }
        return elementData[i];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == e) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(int index, Object e) {
        // 判断索引是否正确
        if (index < 0 || index > size) {
            throw new RuntimeException("数组索引越界!");
        }
        // 数组如果已满则进行扩容  扩容策略：增长一半
        if (size == elementData.length) {
            grow();
        }
        // 后移索引i及其后面索引的元素，从最后一个元素开始
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        // 给指定索引位置赋值
        elementData[index] = e;
        // 元素个数增加
        size++;
    }

    /**
     * 数组扩容
     * 扩容策略：增长一半
     */
    public void grow() {
        // 步骤一：创建新的数组，长度是原来的长度的1.5倍
        Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
        // 步骤二：将旧数组元素拷贝给新数组
        System.arraycopy(elementData, 0, newArray, 0, elementData.length);
        // 步骤三：将elementData指向新的数组
        elementData = newArray;
    }

    @Override
    public void add(Object e) {
        this.add(size, e);
    }

    @Override
    public boolean addBefore(Object e, Object before) {
        // 表中没有指定数字的话返回false
        int index = this.indexOf(before);
        if (index == -1) {
            return false;
        } else {
            this.add(index, e);     // 插入元素到指定位置
            return true;
        }
    }

    @Override
    public boolean addAfter(Object e, Object after) {
        // 表中没有指定数字的话返回false
        int index = this.indexOf(after);
        if (index == -1) {
            return false;
        } else {
            this.add(index + 1, e);     // 插入元素到指定位置
            return true;
        }
    }

    @Override
    public Object remove(int index) {
        // 判断索引是否正确
        if (index < 0 || index > size) {
            throw new RuntimeException("数组索引越界!");
        }
        // 删除索引位置元素: 索引位置后的元素全部提前
        Object element = elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - index);
        size--; // 元素个数减一
        return element;
    }

    @Override
    public boolean remove(Object e) {
        // 表中没有指定数字的话返回false
        int index = this.indexOf(e);
        if (index == -1) {
            return false;
        } else {
            // 删除索引位置元素: 索引位置后的元素全部提前
            Object element = elementData[index];
            System.arraycopy(elementData, index + 1, elementData, index, size - index);
            size--; // 元素个数减一
            return true;
        }
    }

    @Override
    public Object replace(int index, Object e) {
        // 判断索引是否正确
        if (index < 0 || index > size) {
            throw new RuntimeException("数组索引越界!");
        }
        Object element = elementData[index];
        // 将元素替换
        elementData[index] = e;
        return element; // 返回修改前的元素
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                builder.append(elementData[i]).append(",");
            } else {
                builder.append(elementData[i]);
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
