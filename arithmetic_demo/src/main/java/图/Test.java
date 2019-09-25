package 图;

/**
 * 〈测试类〉
 *
 * @author LZ
 * @create 2019/9/24
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        String[] data = {"A","B","C","D","E"};
        AdjacentMatrix adjacentMatrix = new AdjacentMatrix(data);
        // 添加边
        // A-B
        adjacentMatrix.insertEdge(0,1);
        // A-C
        adjacentMatrix.insertEdge(0,2);
        // B-c
        adjacentMatrix.insertEdge(1,2);
        // B-D
        adjacentMatrix.insertEdge(1,3);
        // B-E
        adjacentMatrix.insertEdge(1,4);

        // 展示
        adjacentMatrix.show();

       // 深度优先算法
//        adjacentMatrix.dfs();
        System.out.println();
        // 广度优先算法
        adjacentMatrix.bfs();

    }

}