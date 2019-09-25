/**
 * 〈稀疏数组〉
 *
 * @author LZ
 * @create 2019/7/5
 * @since 1.0.0
 */
public class SparsearrayArr {
    public static void main(String[] args) {
        int[][] params_arr =
                {{0, 1, 0, 0},
                        {2, 0, 0, 0},
                        {0, 0, 0, 0}};


        int[][] sparsearrayArr = arr2sparsearrayArr(params_arr);
        System.out.println("=====稀疏数组");

        for (int[] i : sparsearrayArr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println("");
        }
        System.out.println("===原数组");
        int[][] arr = sparsearrayArr2Arr(sparsearrayArr);

        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }

    /**
     * 数组转稀疏数组
     *
     * @param arr 原数组
     * @return 稀疏数组
     */
    public static int[][] arr2sparsearrayArr(int[][] arr) {
        //1.计算大于0的个数
        int sum = 0;
        for (int[] item : arr) {
            for (int i : item) {
                if (i > 0) {
                    sum++;
                }
            }
        }
        //2.构建稀疏数组
        int[][] sparsearrayArr = new int[sum + 1][3];
        int p = 0;
        sparsearrayArr[p][0] = 3;
        sparsearrayArr[p][1] = 4;
        sparsearrayArr[p][2] = sum;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    p++;
                    sparsearrayArr[p][0] = i;
                    sparsearrayArr[p][1] = j;
                    sparsearrayArr[p][2] = arr[i][j];
                }
            }
        }
        return sparsearrayArr;
    }

    /**
     * 稀疏数组转正常数组
     *
     * @param sparsearrayArr 稀疏数组
     * @return 正常数组
     */
    public static int[][] sparsearrayArr2Arr(int[][] sparsearrayArr) {
        // 初始化数组
        int[][] arr = new int[sparsearrayArr[0][0]][sparsearrayArr[0][1]];
        for (int i = 1; i < sparsearrayArr.length; i++) {
            arr[sparsearrayArr[i][0]][sparsearrayArr[i][1]] = sparsearrayArr[i][2];
        }
        return arr;
    }
}
