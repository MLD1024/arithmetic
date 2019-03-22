package 十大排序算法;

import java.util.ArrayList;

/**
 * @author MND
 * @date 2019/3/21
 * @describe 基数排序（Radix Sort）最佳情况：T(n) = O(n * k)   最差情况：T(n) = O(n * k)   平均情况：T(n) = O(n * k)
 */
public class RadixSort extends BaseTest {

    public static void main(String[] args) {
        test01();
        out_println();
    }

    public static void test01() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = max < arr[i] ? arr[i] : max;
        }
        int for_count = 0;
        while (max > 0) {
            max = max / 10;
            for_count++;
        }
        int mod = 10;
        int div = 1;
        for (int i = 0; i < 10; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int j = 0; j < for_count; j++, mod = mod * 10, div = div * 10) {
            for (int k = 0; k < arr.length; k++) {
                int num = (arr[k] % mod) / div;
                list.get(num).add(arr[k]);
            }
            int index = 0;
            for (int k = 0; k < list.size(); k++) {
                for (int l = 0; l < list.get(k).size(); l++) {
                    arr[index++] = list.get(k).get(l);
                }
                list.get(k).clear();
            }
        }
    }
}
