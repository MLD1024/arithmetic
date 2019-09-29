package 其它算法;

import java.util.Arrays;

/**
 * 〈kmp 算法〉
 *
 * @author LZ
 * @create 2019/9/26
 * @since 1.0.0
 */
@SuppressWarnings("all")
public class KMPSearch {

    public static void main(String[] args) {
        String str1 = "ABCBABE";
        String str2 = "ABE";
        int[] next = kmpNext(str2);
        System.out.println(Arrays.toString(next));
        System.out.println(kmpSearch(str1, str2, next));
    }

    /**
     * @param str1 源字符串
     * @param str2 字串
     * @param next 部分匹配表 字串对应的
     * @return -1 没有匹配到
     */
    public static int kmpSearch(String str1, String str2, int[] next) {

        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }

        return -1;
    }


    /**
     * 返回部分匹配值表
     *
     * @param dest 目标字符串
     * @return int[]
     */
    public static int[] kmpNext(String dest) {

        // 1.创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        for (int i = 1, j = 0; i < next.length; i++) {

            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        return next;
    }
}
