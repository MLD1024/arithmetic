package 其它算法;

/**
 * 〈暴力匹配字符串〉
 *
 * @author LZ
 * @create 2019/9/26
 * @since 1.0.0
 */
public class ViolenceMatch {


    public static void main(String[] args) {
        String str1 = "ABCBABE";
        String str2 = "ABE";
        System.out.println(violenceMatch(str1, str2));

    }


    /**
     * @param str1 带查找的字符串
     * @param str2 目标字符串
     * @return 返回匹配的第一个字符下标 没有则返回-1
     */
    public static int violenceMatch(String str1, String str2) {
        // 1.转化为字符数组
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        // 2. 遍历数组
        for (int i = 0, j = 0; i < str1.length(); i++) {
            //3. 如果字符相等
            if (str1.charAt(i) == str2.charAt(j)) {
                // 3.1 判断 是否已经匹配成功
                if (j == str2.length() - 1) {
                    return i - j;
                }
                // 3.2 没有匹配成功继续往后匹配
                j++;
            } else {
                //4.  回溯
                j = 0;
                i = i - j + 1;
            }
        }
//        int i = 0;
//        int j = 0;
//        while (i < str1.length() && j < str2.length()) {
//            if (s1[i] == s2[j]) {
//                i++;
//                j++;
//            } else {
//                i = i - j + 1;
//                j = 0;
//            }
//        }
//        if(j==s2.length){
//            return i-j;
//        }
        return -1;
    }
}
