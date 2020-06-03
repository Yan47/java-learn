import org.junit.Test;

import java.util.Scanner;

/**
 * @author ：yansiqi
 * @date ：2020/6/3 17:09
 */
public class Earning {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param years        投资年限
     * @param moneyPerYear 每年投资额度
     * @param rate         收益率
     * @return 最后资金量
     */
    private static double earning(int years, int moneyPerYear, int rate) {
        // 第一年初资金
        double earning = 0;
        for (int i = 0; i < years; ++i) {
            // 年初资金
            earning += moneyPerYear;
            // 年末资金
            earning += earning * rate / 100;
        }
        return earning;
    }

    /**
     * 计算一次收益总量
     */
    private static void deployEarning() {
        System.out.println("\n请输入预计投资年份：");
        int years = sc.nextInt();
        System.out.println("请输入预计每年投资金额(万元)：");
        int moneyPerYear = sc.nextInt();
        System.out.println("请输入预计年收益率(百分比)：");
        int rate = sc.nextInt();
        double earning = earning(years, moneyPerYear, rate);
        System.out.printf("计算得到最终收益为：%f万元\n", earning);
    }

    public static void main(String[] args) {
        do {
            deployEarning();
            System.out.println("\n输入y再次计算，输入其他结束计算。");
        } while (sc.next().equals("y"));
        System.out.println("\n程序结束\n");
    }
}
