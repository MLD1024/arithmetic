package 其它算法;

/**
 * 〈二分查找算法〉
 *
 * @author LZ
 * @create 2019/9/24
 * @since 1.0.0
 */
public class BinarySearch {

    /**
     * @param data   带查找的数组（数组）
     * @param target 目标数据
     * @return 返回对应的下标，-1 表示没有找到
     */
    public static int binarySearch(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;
        // 继续查找
        while (high >= low) {
            int mid = (low + high) / 2;
            if (data[mid] == target) {
                return mid;
                // 向左边查找
            } else if (data[mid] > target) {
                high = mid - 1;
                //向右边查找
            } else if (data[mid] < target) {
                low = mid + 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] data = {1,6,8,41,68,100};
        System.out.println(binarySearch(data, 100));
    }

}
