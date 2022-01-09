package week02;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 数组的度
 */
public class Demo02 {
    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 2, 3, 1, 4, 2
        };
        int shortestSubArray = findShortestSubArray(nums);
        System.out.println(shortestSubArray);
    }

    public static int findShortestSubArray(int[] nums) {
        // map中的value 是数组，
        // 第一位存储出现的次数，
        // 第二位存储 第一次出现时在nums中的下标
        // 第三位存储 最后一次在nums中的下标
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            map.compute(nums[i], (k, v) -> {
                if (v == null || v.length == 0) {
                    return new int[]{1, index, index};
                }
                v[0]++;
                v[2] = index;
                return v;
            });
        }
        //获取到最大长度的数组
        int[] reduce = map.values()
                .stream()
                .reduce(new int[3], Demo02::compare);
        return getLength(reduce);
    }

    public static int[] compare(int[] a, int[] b) {
        return a[0] > b[0] ? a : b;
    }

    public static int getLength(int[] nums) {
        return nums[2] - nums[1] + 1;
    }

}
