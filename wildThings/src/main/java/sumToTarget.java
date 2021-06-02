import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sumToTarget {

    private List<Double> finalList = new ArrayList<Double>();
    private static double sum = 1691495.81;

    private int getAllSchemeNum(double[] arr) {
        List<Double> list = new ArrayList<Double>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);

        int count = 0;
        // 将 选择一个数的组合数、选择两个数的组合数、...选择n个数的组合数 相加
        for (int numToSelect = 4; numToSelect <= list.size(); numToSelect++) {
            count += getSchemeNumByNumToSelect(list, numToSelect, sum, 0);
        }
        return count;
    }

    /**
     * 求【从数组的[arr[index], arr[length-1]]片段中获取和为sumToSelect的numToSelect个数】的方案数
     *
     * @param arr         数组
     * @param numToSelect 还需要选择的数的个数
     * @param sumToSelect 还需要选择数之和
     * @param index       可选的范围的左边界
     * @return
     */
    private int getSchemeNumByNumToSelect(List<Double> arr, int numToSelect, double sumToSelect, int index) {
        int count = 0;
        // 递归出口，如果数全部选择完成，则只需判定sumToSelect是否为零，如果为零，符合条件，返回1，否则返回0
        if (numToSelect == 0) {
            double finalListSum = 0;
            for (int i = 0; i < finalList.size(); ++i) {
                finalListSum += finalList.get(i);
//                System.out.printf("%f,", finalList.get(i));
            }
            if (sumToSelect <= 48) {
                for (int i = 0; i < finalList.size(); ++i) {
                    System.out.printf("%f,", finalList.get(i));
                }
                System.out.printf("\n");
                finalList.remove(finalList.size() - 1);
            } else {
                finalList.remove(finalList.size() - 1);
            }


            if (sumToSelect <= 48) {
                return 1;
            } else {

                return 0;
            }
        }
        /*
         * 将问题按选择的第一个数的不同做分解，第一个数可选的范围为[index, arr.length - numToSelect]，
         * 所以就分解成了(arr.length - numToSelect - index + 1)个子问题。可为什么可选下标的右边界是
         * (arr.length - numToSelect)呢？是因为如果第一个数的下标是(arr.length - numToSelect + 1)，
         * 那么后面只剩(numToSelect - 2)个位置，是不够放下剩余的(numToSelect - 1)个值的。
         */
        for (int i = index; i <= arr.size() - numToSelect; i++) {
            if (arr.get(i) <= sumToSelect) {
                finalList.add(arr.get(i));
                /*
                 * 选择了第一个数arr[i]，还需要在剩余数组片段中选择和为(sumToSelect-arr[i])
                 * 的(numToSelect-1)个数。
                 * >> 需要递归
                 */

                count += getSchemeNumByNumToSelect(arr, numToSelect - 1, sumToSelect - arr.get(i), i + 1);

//                if(count>=1){
//                    System.out.printf("%d个数：%f万元。目前剩余和为：%f万元\n", numToSelect,arr.get(i),sumToSelect );
//                }
            }
        }
        if (!finalList.isEmpty()) {
            finalList.remove(finalList.size() - 1);
        }
//        finalList.clear();
        return count;
    }

    @org.junit.Test
    public void test() {
        System.out.println("方案数:" + getAllSchemeNum(new double[]{9994.88, 57499.88, 102208.91, 17242.96, 75844.38, 41333.87, 2364.32, 153098.81, 1180384.43, 1258932.59, 621020.7, 383225.7, 1085920.15, 214235.4, 238323.75}));
    } // out : 方案数:4
}
