package 十大排序算法;

import java.util.Arrays;

/**
 * @author MND
 * @date 2019/3/21
 * @describe
 */
public class BaseTest {
    public static boolean flag = true;//加入标记默认为有序序
    public static int pos = 0;//交换元素，记录最后一次交换的位置
    public static Integer arr[] = {3, 44, 38, 5, 47, 15, 36, 28, 99, 50};
    public static int count = 0;

    public static void out_println() {
        System.out.println(Arrays.toString(arr));
        System.out.println("排序次数：" + count);
    }
}
