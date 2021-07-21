package cn.centuryw.java.datastructure.search;

public class BinSearch {
    /**
     * 折半查找
     *
     * @param array 已排序的数组
     * @param key   要查找的元素
     * @return 找到则返回元素在数组的索引, 否则返回-1
     */
    public static int binarySearch(int[] array, int key) {
        int low = 0, height = array.length - 1, middle;    // 设置索引位置: 头部、底部、中部
        while (low <= height) {
            middle = (low + height) / 2;    // 计算中间值
            if (array[middle] == key) {
                return middle;
            } else if (array[middle] > key) {
                height = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 已排序数组
        int[] array = {5, 13, 19, 21, 37, 56, 64, 75, 80, 88, 92};
        // 要查找的元素
        int selectValue = 5;
        // 打印查找结果
        System.out.println(binarySearch(array, selectValue));
    }
}
