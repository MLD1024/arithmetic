package 其它算法;

import java.util.Arrays;

/**
 * 〈迪杰斯特拉算法〉
 *
 * @author LZ
 * @create 2019/9/29
 * @since 1.0.0
 */
public class DijkstraAlgorithm {

    public static void main(String[] args) {
        String[] data = {"A", "B", "C", "D", "E", "F", "G"};
        //邻接矩阵
        int[][] matrix = new int[data.length][data.length];
        final int N = 65535;// 表示不可以连接
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};
        Graph graph = new Graph(data, matrix);
        graph.djf(6);
        graph.showVisitedVertex();
    }

}

class Graph {
    /**
     * 顶点数组
     */
    public String[] data;

    /**
     * 邻接矩阵
     */
    public int[][] matrix;


    private VisitedVertex vv;


    public Graph(String[] data, int[][] matrix) {
        this.data = data;
        this.matrix = matrix;
    }

    public void show() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public void djf(int index) {
        this.vv = new VisitedVertex(data.length, index);
        update(index);
        for (int j = 1; j < data.length; j++) {
            // 更新index顶点到周围顶点的距离和前驱顶点
            update(vv.nextPoint());
        }
    }

    public void update(int index) {
        // 获得当前行xinxi
        int len = 0;
        int[] rows = matrix[index];
        //根据遍历我们的邻接矩阵的  matrix[index]行
        for (int j = 0; j < rows.length; j++) {
            // len 含义是 : 出发顶点到index顶点的距离 + 从index顶点到j顶点的距离的和
            len = vv.dis[index] + rows[j];
            // 如果j顶点没有被访问过，并且 len 小于出发顶点到j顶点的距离，就需要更新
            if (!vv.in(j) && len < vv.dis[j]) {
                vv.updatePreVisited(j, index); //更新j顶点的前驱为index顶点
                vv.updateDis(j, len); //更新出发顶点到j顶点的距离
            }
        }
    }

    public void showVisitedVertex() {
        System.out.println(vv);
    }

}

class VisitedVertex {
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
     * @param length 顶点长度
     * @param index  出发顶点
     */
    public VisitedVertex(int length, int index) {
        this.already = new boolean[length];
        Arrays.fill(already, false);
        this.preVisited = new int[length];
        this.dis = new int[length];
        Arrays.fill(dis, 65535);
        this.already[index] = true; //设置出发顶点被访问过
        dis[index] = 0;
    }

    public int nextPoint() {
        int min = 65535, index = 0;
        for (int i = 0; i < dis.length; i++) {
            int current = dis[i];
            if (!already[i] && current < min) {
                min = current;
                index = i;
            }
        }
        //更新 index 顶点被访问过
        already[index] = true;
        return index;
    }

    public void updateDis(int index, int len) {
        dis[index] = len < dis[index] ? len : dis[index];
    }

    public void updateAlready(int index) {
        already[index] = true;
    }

    public void updatePreVisited(int pre, int index) {
        preVisited[pre] = index;
    }


    public boolean in(int index) {
        return already[index];
    }

    @Override
    public String toString() {
        return "already: " + Arrays.toString(already) + "\n" + "preVisited: " + Arrays.toString(preVisited) + "\n" + "dis: " + Arrays.toString(dis);
    }
}
