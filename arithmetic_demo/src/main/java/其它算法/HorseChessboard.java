package 其它算法;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈马踏棋盘 算法〉
 *
 * @author LZ
 * @create 2019/9/29
 * @since 1.0.0
 */
public class HorseChessboard {
    // 列数
    private int width;
    // 行数
    private int height;

    // 访问记录
    private boolean visited[];

    // 棋盘
    private int[][] chessboard;

    /**
     * 总的步数
     */
    private boolean finished = false;

    public static void main(String[] args) {
        HorseChessboard horseChessboard = new HorseChessboard(8, 8);
        long start = System.currentTimeMillis();
        horseChessboard.start(new Point(0, 0), 1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        horseChessboard.show();
    }


    public HorseChessboard(int width, int height) {
        this.width = width;
        this.height = height;
        this.chessboard = new int[width][height];
        this.visited = new boolean[width * height];
        Arrays.fill(this.visited, false);
    }


    public void start(Point p, int step) {
        // 标记该点第几步
        this.chessboard[p.x][p.y] = step;
        // 标记以访问过
        int index = p.y * width + p.x;
        this.visited[index] = true;
        // 寻找下一个
        List<Point> ps = findNextStep(p);
        sort(ps);
        while (!ps.isEmpty()) {
            Point point = ps.remove(0);
            // 判断是否访问过
            if (!in(point)) {
                this.start(point, step + 1);
            }
        }
        //  回溯
        if (step < width * height && !finished) {
            chessboard[p.x][p.y] = 0;
            visited[p.y * width + p.x] = false;
        } else {
            finished = true;
        }
    }


    private List<Point> findNextStep(Point p) {
        List<Point> ps = new ArrayList<>();
        Point nextPoint = new Point();
        // 0
        if ((nextPoint.x = p.x + 2) < width && (nextPoint.y = p.y + 1) < height) {
            ps.add(new Point(nextPoint));
        }
        // 7
        if ((nextPoint.x = p.x + 1) < width && (nextPoint.y = p.y + 2) < height) {
            ps.add(new Point(nextPoint));
        }
        // 6
        if ((nextPoint.x = p.x - 1) >= 0 && (nextPoint.y = p.y + 2) < height) {
            ps.add(new Point(nextPoint));
        }
        // 5
        if ((nextPoint.x = p.x - 2) >= 0 && (nextPoint.y = p.y + 1) < height) {
            ps.add(new Point(nextPoint));
        }
        // 4
        if ((nextPoint.x = p.x - 2) >= 0 && (nextPoint.y = p.y - 1) >= 0) {
            ps.add(new Point(nextPoint));
        }
        // 3
        if ((nextPoint.x = p.x - 1) >= 0 && (nextPoint.y = p.y - 2) >= 0) {
            ps.add(new Point(nextPoint));
        }
        // 2
        if ((nextPoint.x = p.x + 1) < width && (nextPoint.y = p.y - 2) >= 0) {
            ps.add(new Point(nextPoint));
        }
        // 1
        if ((nextPoint.x = p.x + 2) < width && (nextPoint.y = p.y - 1) >= 0) {
            ps.add(new Point(nextPoint));
        }
        return ps;
    }

    /**
     * 展示
     */
    public void show() {
        for (int[] ints : this.chessboard) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }


    /**
     * 判断是否访问过
     *
     * @param p 待判断的端点
     * @return boolean
     */
    private boolean in(Point p) {

        return this.visited[p.y * width + p.x];

    }

    /**
     * 进行非递减排序
     *
     * @param ps 待排序的集合
     */
    public void sort(List<Point> ps) {
        ps.sort((item1, item2) -> {
            int count1 = findNextStep(item1).size();
            int count2 = findNextStep(item2).size();
            if (count1 < count2) {
                return -1;
            } else if (count1 == count2) {
                return 0;
            } else {
                return 1;
            }
        });
    }


}
