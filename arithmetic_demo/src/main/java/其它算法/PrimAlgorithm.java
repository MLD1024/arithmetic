package 其它算法;

import 图.AdjacentMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈普里姆算法〉
 *
 * @author LZ
 * @create 2019/9/26
 * @since 1.0.0
 */
public class PrimAlgorithm {

    public static void main(String[] args) {
        // 1.构建图
        String[] data = {"A", "B", "C", "D", "E", "F", "G"};
        int[][] edges = new int[data.length][data.length];
        for (int[] edge : edges) {
            for (int i = 0; i < edge.length; i++) {
                edge[i] = 100000;
            }
        }
        AdjacentMatrix adjacentMatrix = new AdjacentMatrix(data, edges);
        // A-B
        adjacentMatrix.insertEdge(0, 1, 5);
        // B-D
        adjacentMatrix.insertEdge(1, 3, 9);
        // D-F
        adjacentMatrix.insertEdge(3, 5, 4);
        //F-E
        adjacentMatrix.insertEdge(5, 4, 5);
        //E-C
        adjacentMatrix.insertEdge(4, 2, 8);
        //C-A
        adjacentMatrix.insertEdge(2, 0, 7);
        //G-A
        adjacentMatrix.insertEdge(6, 0, 2);
        //G-B
        adjacentMatrix.insertEdge(6, 1, 3);
        //G-F
        adjacentMatrix.insertEdge(6, 5, 6);
        //G-E
        adjacentMatrix.insertEdge(6, 4, 4);
//        adjacentMatrix.show();
        primAlgorithm(adjacentMatrix);
    }

    /**
     * @param adjacentMatrix 图结构
     */
    public static void primAlgorithm(AdjacentMatrix adjacentMatrix) {
        // 1.获取顶点的集合
        String[] data = adjacentMatrix.getData();
        // 2. 获取图的邻接矩阵
        int[][] edges = adjacentMatrix.getEdges();
        int[] temp = null;
        int minWeightIndex = -1;
        int minWeight = -1;
        int minStart = -1;
        //3. 头结点
        int i = 0;
        //4. pathData
        List<String> pathData = new ArrayList<>();
        List<Integer> select = new ArrayList<>();
        while (pathData.size() < data.length - 1) {
            select.add(i);
            adjacentMatrix.isVisited[i] = true;
            minWeightIndex = -1;
            minWeight = -1;
            minStart = -1;
            for (Integer item : select) {
                temp = edges[item];
                for (int j = 0; j < temp.length; j++) {
                    int weight = temp[j];
                    if (adjacentMatrix.isVisited[j]) {
                        continue;
                    }
                    if (minWeight == -1 || weight <= minWeight) {
                        minWeight = weight;
                        minWeightIndex = j;
                        minStart = item;
                    }
                }
            }
            pathData.add(data[minStart] + "====>" + data[minWeightIndex] + "权重" + minWeight);
            i = minWeightIndex;
            adjacentMatrix.isVisited[minWeightIndex] = true;
        }
        System.out.println(pathData.toString());
    }

}
