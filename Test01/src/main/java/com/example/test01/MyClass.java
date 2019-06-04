package com.example.test01;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jkl on 2019/6/4 01:18.  算法习题1
 */

public class MyClass {

    public static void main(String[] args) {
        int[] a = new int[]{4, 1, 2, 1, 5};
        System.out.println(twoSum(a,9)[0]);
        System.out.println(twoSum(a,9)[1]);
    }


    /**
     * 数组题一：只出现一次的元素
     * <p>
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * 示例 1:
     * 输入: [2,2,1]  输出: 1
     * 示例 2:
     * 输入: [4,1,2,1,2]  输出: 4
     */
    public static int singleNumber(int[] nums) {
        int a = 0;
        for (int n : nums) {
            a = a ^ n;
        }
        return a;
    }

    /**
     * 《数组题二：存在重复》
     * 给定一个整数数组，判断是否存在重复元素。
     * <p>
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     * <p>
     * 示例 1:
     * 输入: [1,2,3,1]
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: [1,2,3,4]
     * 输出: false
     * <p>
     * 示例 3:
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     *
     * @param nums 给定的数组
     * @return true, false
     */

    private static boolean test030(int[] nums) {
        if (nums.length < 1) {
            return false;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int a : nums) {
            if (hashMap.containsKey(a)) {
                return true;
            } else {
                hashMap.put(a, 1);
            }
        }
        return false;
    }

    /**
     * 《数组题二：两数之和》
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    private static int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    array[0] = i;
                    array[1] = j;
                }
            }
        }
        return array;
    }

}
