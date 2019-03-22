package 十大排序算法;


/**
 * @author MND
 * @date 2019/3/21
 * @describe 计数排序（Counting Sort） 最佳情况：T(n) = O(n+k)  最差情况：T(n) = O(n+k)  平均情况：T(n) = O(n+k)
 *当输入的元素是n 个0到k之间的整数时，它的运行时间是 O(n + k)。计数排序不是比较排序，排序的速度快于任何比较排序算法。由于用来计数的数组C的长度取决于待排序数组中数据的范围（等于待排序数组的最大值与最小值的差加上1），这使得计数排序对于数据范围很大的数组，需要大量时间和内存。
 */
public class CountingSort extends  BaseTest {

    public static void main(String[] args) {
        test01();
        out_println();
    }

    public  static  void  test01(){
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i <arr.length ; i++) {
            min = min>arr[i]?arr[i]:min;
            max=max<arr[i]?arr[i]:max;
        }
        int[] bucket = new int[max - min + 1];
        for (int i = 0; i  <arr.length; i++) {
            bucket[arr[i]-min]++;
        }
        int index = 0;
        int j = 0;
        while (j < arr.length) {
            if(bucket[index]!=0){
                arr[j++] = index+min;
                bucket[index]--;
            }else {
                index++;
            }
        }
    }
}
