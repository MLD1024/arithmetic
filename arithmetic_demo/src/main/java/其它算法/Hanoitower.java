package 其它算法;

/**
 * 〈汉诺塔游戏解决办法〉
 *
 * @author LZ
 * @create 2019/9/24
 * @since 1.0.0
 */
public class Hanoitower {

    /**
     * 默认三个塔柱分别为 A，B ，C
     * 默认把塔A 数据移动到塔C 上
     *
     * @param num   盘的个数
     * @param start 开始的塔柱
     * @param mid   中间的塔柱
     * @param end   目标塔柱
     */
    public static void hanoiTower(int num, char start, char mid, char end) {

        if (num == 1) {
            System.out.println("第"+num+"盘从 "+start+"----》"+end);
        } else if (num >= 2) {
            //1. 把1到(num-1)的盘从A移动到B
            hanoiTower(num-1,start,end,mid);
            //2. 把第num的盘从A移动到C
            System.out.println("第"+num+"盘从 "+start+"----》"+end);
            //3. 把1到(num-1)的盘从B移动到C
            hanoiTower(num-1,mid,start,end);
        } else {
            throw new RuntimeException("num must be greater than 0");
        }
    }

    public static void main(String[] args) {
        hanoiTower(64,'A','B','C');
    }
}
