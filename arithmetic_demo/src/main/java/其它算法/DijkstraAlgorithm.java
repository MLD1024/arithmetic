package 其它算法;

/**
 * 〈迪杰斯特拉算法〉
 *
 * @author LZ
 * @create 2019/9/29
 * @since 1.0.0
 */
public class DijkstraAlgorithm {
    /**
     * 记录各个顶点是否访问过
     */
    public boolean[] already;
    /**
     * 前一个顶点下标
     */
    public int[] preVisited;
    /**
     * 记录出发顶点到其它所有顶点的距离
     */
    public int[] dis;

    /**
     * 顶点数组
     */
    public String[] data;

    /**
     * 邻接矩阵
     */
    public int[][] matrix;



    public void dijkstraAlgorithm(String poit){
        // 找到下标
        int index = findIndex(poit);
        // 遍历
        for (int i = 0; i < matrix[index].length; i++) {
            if(!already[i]){
//                if
            }
        }

    }

    /**
     * 返回给定结点的数组下标 如果没有则放回 -1
     * @param poit 给定结点
     * @return int
     */
    public int findIndex(String poit){
        for (int i = 0; i < data.length; i++) {
           if(data[i].equals(poit)){
               return i;
           }
        }
        return  -1;
    }
}
