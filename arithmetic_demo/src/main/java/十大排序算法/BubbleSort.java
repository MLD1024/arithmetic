package 十大排序算法;

import java.util.Arrays;

/**
 * @author MND
 * @date 2019/3/21
 * @describe 冒泡排序  最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
 */
public class BubbleSort {
    private  static  boolean flag = true;//加入标记默认为有序序
    private  static  int    pos = 0;//交换元素，记录最后一次交换的位置
    private  static  int arr[] = {1,2,5,7,4,3,6,8,9,10};
    private static int count = 0;
    public static void main(String[] args) {
//        test01();
//        test02();
//        test03();
//        test04();
        System.out.println(Arrays.toString(arr));
        System.out.println("排序次数："+count);
    }

    public static void test01(){
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    arr[j+1]=arr[j+1]+arr[j];
                    arr[j] = arr[j+1]-arr[j];
                    arr[j+1] = arr[j+1]-arr[j];
                    flag = false;
                }
                count++;
            }
        }
    }
    public static void test02(){
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    arr[j+1]=arr[j+1]+arr[j];
                    arr[j] = arr[j+1]-arr[j];
                    arr[j+1] = arr[j+1]-arr[j];
                }
                count++;
            }
        }
    }
    public static void test03(){
        for(int i=0;i<arr.length;i++){
            flag = true;
            for (int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    arr[j+1]=arr[j+1]+arr[j];
                    arr[j] = arr[j+1]-arr[j];
                    arr[j+1] = arr[j+1]-arr[j];
                    flag = false;
                }
                count++;
            }
            //如果没有交换过元素，则已经有序
            if(flag){
                return;
            }
        }
    }
    public static void test04(){
       int temp = arr.length-1;
        for(int i=0;i<arr.length;i++){
            flag = true;
            for (int j=0;j<temp;j++){
                if(arr[j]>arr[j+1]){
                    arr[j+1]=arr[j+1]+arr[j];
                    arr[j] = arr[j+1]-arr[j];
                    arr[j+1] = arr[j+1]-arr[j];
                    flag = false;
                    pos = j;//交换元素，记录最后一次交换的位置
                }
                count++;
            }
            //如果没有交换过元素，则已经有序
            if(flag){
                return;
            }
            temp = pos;
        }
    }
}
