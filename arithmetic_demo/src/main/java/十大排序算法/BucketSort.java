package 十大排序算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author MND
 * @date 2019/3/21
 * @describe 桶排序（Bucket Sort）桶排序最好情况下使用线性时间O(n)，桶排序的时间复杂度，取决与对各个桶之间数据进行排序的时间复杂度，因为其它部分的时间复杂度都为O(n)。很显然，桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。但相应的空间消耗就会增大。
 * 最佳情况：T(n) = O(n+k)   最差情况：T(n) = O(n+k)   平均情况：T(n) = O(n2)
 */
public class BucketSort extends  BaseTest  {
    public static void main(String[] args) {
        List<Integer> result_arr = test01(Arrays.asList(arr), 2);
        System.out.println(result_arr);
//        out_println();
    }

    public static List<Integer> test01(List<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2){
            return array;
        }
        int min = array.get(0);
        int max = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            max = max < array.get(i) ? array.get(i) : max;
            min = min > array.get(i) ? array.get(i) : min;
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) {
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }

            } else {
                if (bucketCount == 1) {
                    bucketSize--;
                }
                List<Integer> temp = test01(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++) {
                    resultArr.add(temp.get(j));
                }
            }
        }
//        arr = resultArr.toArray(arr);
        return resultArr;
    }
}
