package 十大排序算法;

/**
 * @author MND
 * @date 2019/3/21
 * @describe   插入排序（Insertion Sort）  最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
 */
public class InsertionSort extends  BaseTest{
    public static void main(String[] args) {
        test01();

    }

    public static void test01(){
        int current;
        for(int i=0;i<arr.length-1;i++){
            current = arr[i+1];
            int perIndex = i;
            while (perIndex>=0&&current<arr[perIndex]){
                arr[perIndex+1] = arr[perIndex];
                 perIndex--;
                 count++;
            }
            arr[perIndex+1] = current;
        }
        out_println();
    }

}
