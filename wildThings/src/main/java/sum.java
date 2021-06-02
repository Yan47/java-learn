//import java.util.Scanner;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//
//
///**
// * @author ：yansiqi
// * @date ：2020/6/3 17:09
// */
//public class sum {
//
//    private static Scanner sc = new Scanner(System.in);
//
//    /**
//     * @param years        投资年限
//     * @param moneyPerYear 每年投资额度
//     * @param rate         收益率
//     * @return 最后资金量
//     */
//    private static double earning(int years, int moneyPerYear, int rate) {
//        // 第一年初资金
//        double earning = 0;
//        for (int i = 0; i < years; ++i) {
//            // 年初资金
//            earning += moneyPerYear;
//            // 年末资金
//            earning += earning * rate / 100;
//        }
//        return earning;
//    }
//
//    /**
//     * 计算一次收益总量
//     */
//    private static void deployEarning() {
//        System.out.println("\n请输入预计投资年份：");
//        int years = sc.nextInt();
//        System.out.println("请输入预计每年投资金额(万元)：");
//        int moneyPerYear = sc.nextInt();
//        System.out.println("请输入预计年收益率(百分比)：");
//        int rate = sc.nextInt();
//        double earning = earning(years, moneyPerYear, rate);
//        System.out.printf("计算得到最终收益为：%f万元\n", earning);
//    }
//
//    public static void main(String[] args) {
//        do {
//            deployEarning();
//            System.out.println("\n输入y再次计算，输入其他结束计算。");
//        } while (sc.next().equals("y"));
//        System.out.println("\n程序结束\n");
//    }
//
//
//
//
//    @org.junit.Test
//    public void test() {
//        System.out.println("方案数:" + getAllSchemeNum(new int[]{ 5, 5, 5, 2, 3 }, 15));
//    } // out : 方案数:4
//
//    /**
//     * 从数组中选择和为sum的任意个数的组合数
//     */
//    private int getAllSchemeNum(int[] arr, int sum) {
//        int count = 0;
//        // 将 选择一个数的组合数、选择两个数的组合数、...选择n个数的组合数 相加
//        for (int numToSelect = 1; numToSelect <= arr.length; numToSelect++) {
//            count += getSchemeNumByNumToSelect(arr, numToSelect, sum, 0);
//        }
//        return count;
//    }
//
//    /**
//     * 求【从数组的[arr[index], arr[length-1]]片段中获取和为sumToSelect的numToSelect个数】的方案数
//     * @param arr 数组
//     * @param numToSelect 还需要选择的数的个数
//     * @param sumToSelect 还需要选择数之和
//     * @param index 可选的范围的左边界
//     * @return
//     */
//    private int getSchemeNumByNumToSelect(int[] arr, int numToSelect, int sumToSelect, int index) {
//        int count = 0;
//        // 递归出口，如果数全部选择完成，则只需判定sumToSelect是否为零，如果为零，符合条件，返回1，否则返回0
//        if (numToSelect == 0) {
//            return sumToSelect == 0 ? 1 : 0;
//        }
//        /*
//         * 将问题按选择的第一个数的不同做分解，第一个数可选的范围为[index, arr.length - numToSelect]，
//         * 所以就分解成了(arr.length - numToSelect - index + 1)个子问题。可为什么可选下标的右边界是
//         * (arr.length - numToSelect)呢？是因为如果第一个数的下标是(arr.length - numToSelect + 1)，
//         * 那么后面只剩(numToSelect - 2)个位置，是不够放下剩余的(numToSelect - 1)个值的。
//         */
//        for (int i = index; i <= arr.length - numToSelect; i++) {
//            if (arr[i] <= sumToSelect) {
//                /*
//                 * 选择了第一个数arr[i]，还需要在剩余数组片段中选择和为(sumToSelect-arr[i])
//                 * 的(numToSelect-1)个数。
//                 * >> 需要递归
//                 */
//                count += getSchemeNumByNumToSelect(arr, numToSelect - 1, sumToSelect - arr[i], i + 1);
//            }
//        }
//        return count;
//    }
//
//
//
//    public class ArrayAdd {
//
//        public static void main(String[] args) {
//            DataFactory df = new DataFactory();
//            List<Integer> list = new ArrayList<Integer>();
//            for (int i = 0; i < 1000; i++) {
//                list.add(df.getNumber());
//            }
//            Collections.sort(list);
//            final int m = 5000;
//            int a = m - list.get(0) - list.get(1);
//            int b = 0;
//            for (int i = 0; i < list.size(); i++) {
//                if (m < i) {
//                    continue;
//                }
//                for (int j = i + 1; j < list.size(); j++) {
//                    if (m < i + j) {
//                        continue;
//                    }
//                    for (int j2 = j + 1; j2 < list.size(); j2++) {
//                        if (m == i + j + j2) {
//                            System.out.println("i=" + i + ",j=" + j + ",j2=" + j2);
//                            System.out.println("num1+" + list.get(i) + "num2="
//                                    + list.get(j) + "num3=" + list.get(j2));
//                        } else {
//                            if (m < i + j + j2) {
//                                continue;
//                            }
//                        }
//                    }
//                }
//            }
//
//        }
//    }
//}
