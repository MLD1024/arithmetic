package 十大排序算法;

import java.util.Arrays;

/**
 * @author MND
 * @date 2019/3/21
 * @describe 归并排序（Merge Sort） 最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
 */
public class MergeSort extends BaseTest {

    public static void main(String[] args) {
        test01();
        out_println();
    }

    public static void  test01(){

    }
    public static  int[] mergeSort(int[] array){
        if(array.length<2){
            return array;
        }else {
            int mid = array.length/2;
            int[] left = Arrays.copyOfRange(array,0,mid);
            int[] right = Arrays.copyOfRange(array,mid,array.length);
            return  merge(left,right);
        }

    }
    public  static int[] merge(int[] left,int[] right){
        int[] result = new int[left.length+right.length];
        int i=0;
        int j =0 ;
        for (int index = 0; index <result.length ; index++) {
            if(i>=left.length){
                result[index] = right[j++];
            }else if(j>=right.length){
                result[index] = left[i++];
            }else if(left[i]>right[j]){
                result[index] = right[j++];
            }else {
                result[index] = left[i++];
            }
        }
        return  result;
    }
}
