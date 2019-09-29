package 图;

import sun.security.provider.certpath.Vertex;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 〈邻接矩阵 表示图〉
 *
 * @author LZ
 * @create 2019/9/24
 * @since 1.0.0
 */
public class AdjacentMatrix {

    /**
     * 图的数据集
     */
    private String[] data = null;

    /**
     * 邻接矩阵
     */
    private int[][] edges = null;

    /**
     * 数据个数
     */
    private int size;

    public boolean isVisited[] = null;


    /**
     * 顶点集合
     */
    public int[] ends;

    public int getEnd(int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    public int[][] getEdges() {
        return this.edges;
    }

    public String[] getData() {
        return this.data;
    }


    public AdjacentMatrix(String[] data) {
        this.data = data;
        this.edges = new int[data.length][data.length];
        this.isVisited = new boolean[data.length];
        this.ends = new int[data.length];
    }

    public AdjacentMatrix(String[] data, int[][] edges) {
        this.data = data;
        this.edges = edges;
        this.isVisited = new boolean[data.length];
        this.ends = new int[data.length];
    }

    public void insertVertex() {

    }


    public String getValueByIndex(int i) {

        return data[i];
    }

    /**
     * @param v1 第几个顶点
     * @param v2 相邻的下个节点
     */
    public void insertEdge(int v1, int v2) {
        insertEdge(v1, v2, 1);
    }

    /**
     * @param v1     第几个顶点
     * @param v2     相邻的下个节点
     * @param weight 权重
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        size++;
    }

    /**
     * 依据顶点获取index
     *
     * @param vertex 顶点
     * @return index
     */
    public int getDataIndex(String vertex) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(vertex)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 展示图
     */
    public void show() {
        for (int[] temp : edges) {
            System.out.println(Arrays.toString(temp));
        }
    }

    /**
     * 深度优先遍历
     */
    public void dfs() {
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i]) {
                dfs(i);
            }

        }
        System.out.print("尾节点");
    }

    /**
     * @param i 当前处理的数据角标
     */
    public void dfs(int i) {
        if (!isVisited[i]) {
            // 1. 输出当前节点
            System.out.print(getValueByIndex(i) + "--->");
            // 2. 置为true
            isVisited[i] = true;
            //3. 查找下个节点
            int w = getNextNode(i);
            //4. 判断是否存在
            while (w != -1) {
                // 4.1 没有访问过
                if (!isVisited[w]) {
                    dfs(w);
                }
                // 4.2 已经访问过 寻找下个节点
                w = getJumpNode(i, w);

            }

        }

    }

    /**
     * @param i 当前节点
     * @return 下一个节点
     */
    private int getNextNode(int i) {
        int[] data = edges[i];
        for (int j = 0; j < data.length; j++) {
            if (data[j] != 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * @param i         当前节点
     * @param jumpIndex 跳过节点
     * @return 下一个节点
     */
    private int getJumpNode(int i, int jumpIndex) {
        for (int j = jumpIndex + 1; j < data.length; j++) {
            if (edges[i][j] > 0) {
                return j;
            }
        }
        return -1;
    }


    /**
     * 广度优先遍历
     */
    public void bfs() {
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i]) {
                bfs(i);
            }

        }
        bfs(0);
        System.out.print("尾节点");
    }

    /**
     * 广度优先遍历
     */
    public void bfs(int i) {

        // 1.队列 记录结点访问的顺序
        LinkedList<Integer> queue = new LinkedList();
        // 2.访问结点，输出结点信息
        System.out.print(getValueByIndex(i) + "===>");
        // 3.标记为以访问
        isVisited[i] = true;
        // 4. 将结点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            // 5. 取出队列头结点的下标
            int u = queue.removeFirst();
            // 6. 第一个相邻的结点的下标 w
            int w = getNextNode(u);
            while (w != -1) {
                // 7. w 没有访问过
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "===>");
                    // 7.1 标记已经访问
                    isVisited[w] = true;
                    // 7.2 入队
                    queue.addLast(w);
                }
                // 以u 为前驱结点，找到w后面的下一个邻结点(广度优先的体现)
                w = getJumpNode(u, w);
            }
        }
    }

}
