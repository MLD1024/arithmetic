package 十大排序算法;

/**
 * @author MND
 * @date 2019/3/21
 * @describe 希尔排序（Shell Sort） 最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)　
 */
public class ShellSort extends BaseTest {


    public static void main(String[] args) {
        test01();
        out_println();
    }

    public  static  void test01(){
        int size = arr.length;
        int current;
        int gap = size/2;

        while (gap>1){

            for (int i = gap; i <size ; i++) {
                current = arr[i];
               int perindex = i-gap;
                while (perindex>0&&arr[perindex]>current){
                        arr[perindex+gap] = arr[perindex];
                        perindex -= gap;
                        count++;
                }
                arr[perindex+gap] = current;
            }
            gap = gap/2;
        }
    }

}
