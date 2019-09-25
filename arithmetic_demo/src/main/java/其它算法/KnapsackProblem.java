package 其它算法;

import java.util.Arrays;

/**
 * 〈动态规划问题〉
 *
 * @author LZ
 * @create 2019/9/25
 * @since 1.0.0
 */
public class KnapsackProblem {


    // weight  worth previous current

    /**
     * @param worth       价值数组 wotrh[i] 第i个物品的价值
     * @param weight      重量数组 weight[i] 第i个物品的重量
     * @param totalWeight 背包总的承重
     */
    public static void knapsackProblem(int[] worth, int[] weight, int totalWeight) {
        //1. 初始化数组 data[i][j] 前i个物品能装入容量为j的背包
        int[][] data = new int[worth.length + 1][totalWeight + 1];
        //1.1 路径数组
        int[][] path = new int[worth.length + 1][totalWeight + 1];

        //2.给数组复制 i 行 j 列
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                // 2.1 i=0 表示0个物品 j=0 表示j 容量为0
                if (i == 0 || j == 0) {
                    data[i][j] = 0;
                    //2.2 weight[i] >j 表示 第i个物品的重量大于背包总载重
                } else if (weight[i - 1] > j) {
                    data[i][j] = data[i - 1][j];
                    // 2.3 weight[i] ,j 表示 第i个物品的重量小于于背包总载重
                } else {
                    int previous = data[i - 1][j];
                    int current = worth[i - 1] + data[i - 1][j - weight[i - 1]];
                    if (current > previous) {
                        data[i][j] = current;
                        path[i][j] = 1;
                    } else {
                        data[i][j] = previous;
                    }
                }
            }
        }
        for (int[] datum : data) {
            System.out.println(Arrays.toString(datum));
        }
        for (int[] datum : path) {
            System.out.println(Arrays.toString(datum));
        }
        int i = path.length-1;
        int j = path[0].length-1;
        while (i>0&&j>0){
            if (path[i][j]==1){
                System.out.printf("第%d个商品放入背包\n",i);
                j -= weight[i-1];
            }
            i--;
        }

    }

    public static void main(String[] args) {
        int[] worth = {1500, 3000, 2000};
        int[] weight = {1, 4, 3};
        int totalWeight = 4;
        knapsackProblem(worth, weight, totalWeight);
    }
}
