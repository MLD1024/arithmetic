package 其它算法;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import 图.AdjacentMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈克鲁斯卡尔算法〉
 *
 * @author LZ
 * @create 2019/9/27
 * @since 1.0.0
 */
public class KrusKalCase {


    public static void main(String[] args) {
        String[] data = {"A", "B", "C", "D", "E", "F", "G"};
        int[][] edges = new int[data.length][data.length];
        for (int[] edge : edges) {
            for (int i = 0; i < edge.length; i++) {
                edge[i] = 0;
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
        System.out.println(krusKalCase(adjacentMatrix));
    }

    /**
     * @param adjacentMatrix 图结构
     * @return optimalPathList
     */
    public static List<PathData> krusKalCase(AdjacentMatrix adjacentMatrix) {
        // 获取顶点集合
        String[] data = adjacentMatrix.getData();
        // 获取邻接矩阵
        int[][] edges = adjacentMatrix.getEdges();
        //optimalPatnList
        List<PathData> optimalPathList = new ArrayList<>();
        // 获取所有的路径
        List<PathData> allPath = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            for (int j = i+1; j < edges[i].length; j++) {
                if (edges[i][j] > 0) {
                    allPath.add(new PathData().setStart(data[i]).setEnd(data[j]).setWeight(edges[i][j]));
                }
            }
        }
        // 从小到大排序(冒泡排序)
        for (int i = 0; i < allPath.size(); i++) {
            for (int j = 0; j < allPath.size() - 1; j++) {
                PathData current = allPath.get(j);
                PathData next = allPath.get(j + 1);
                if (current.getWeight() > next.getWeight()) {
                    allPath.set(j, next);
                    allPath.set(j + 1, current);
                }
            }
        }

        for (int i = 0; i < allPath.size(); i++) {
            //当前路径
            PathData item = allPath.get(i);
            // 头结点
            String start = item.getStart();
            int startIndex = adjacentMatrix.getDataIndex(start);
            int p = adjacentMatrix.getEnd(startIndex);
            // 尾结点
            String end = item.getEnd();
            int endIndex = adjacentMatrix.getDataIndex(end);
            int q = adjacentMatrix.getEnd(endIndex);
            //是否构成回路
            if ( p!= q ) {
                adjacentMatrix.ends[p] = q;
                optimalPathList.add(item);
            }
        }

        return optimalPathList;
    }


}


@Setter
@Getter
@Accessors(chain = true)
class PathData {
    /**
     * 头顶点
     */
    private String start;
    /**
     * 尾顶点
     */
    private String end;
    /**
     * 权重
     */
    private int weight;


    @Override
    public String toString() {
        return "边<" + start + "，" + end + "> 权值:" + weight;
    }
}
