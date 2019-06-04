package com.example.test01;


import java.util.HashMap;

/**
 * @author jkl on 2019/6/4 01:18.  算法习题1
 */

public class MyClass {

    public static void main(String[] args) {
        int[] a = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(a));
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
        for (int n: nums) {
            a = a ^ n;
        }
        return a;
    }

    /**
     * 《数组题一：存在重复》
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

    private static boolean Test030(int[] nums) {
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
}
