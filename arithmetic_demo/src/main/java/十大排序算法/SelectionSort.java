package 十大排序算法;

import java.util.Arrays;

/**
 * @author MND
 * @date 2019/3/21
 * @describe 选择排序（Selection Sort） 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
 */
public class SelectionSort extends BaseTest {
    public static void main(String[] args) {
        test01();
    }

    public static  void  test01(){
        for(int i=0;i<arr.length;i++){
            int minindex = i;
            for (int j=i+1;j<arr.length;j++){
                if(arr[minindex]>arr[j]){
                    minindex=j;
                }
                count++;
            }
//            arr[minindex] = arr[i]+arr[minindex];
//            arr[i] = arr[minindex]-arr[i];
//            arr[minindex] = arr[minindex]-arr[i];
//            i==minindex 会有bug

            int temp = arr[minindex];
            arr[minindex] = arr[i];
            arr[i] = temp;
        }
        out_println();
    }
}
