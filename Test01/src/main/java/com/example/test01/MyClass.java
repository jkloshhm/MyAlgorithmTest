package com.example.test01;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author jkl on 2019/6/4 01:18.  算法习题1
 */

public class MyClass {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 0, 0, 0, 0};
        int[] b = new int[]{1, 2, 5, 6};
        //System.out.println(Arrays.toString(moveZeroes(a)));
        //System.out.println(twoSum(a, 9)[1]);
        //System.out.println(Arrays.toString(intersect(a, b)));
        majorityElement(a);
        merge(a, 3, b, 4);
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


    /**
     * 《数组题：加一》
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * 示例 1:
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * <p>
     * 示例 2:
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     */

    public static int[] plusOne(int[] digits) {

        if (digits.length < 1) {
            return digits;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }

        if (digits[0] == 0) {
            int[] a = new int[digits.length + 1];
            a[0] = 1;
            for (int i = 1; i < digits.length + 1; i++) {
                a[i] = 0;
            }
            return a;
        }

        return digits;
    }


    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * <p>
     * 1、必须在原数组上操作，不能拷贝额外的数组。
     * 2、尽量减少操作次数。
     */

    private static int[] moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        j = nums.length;
                    }
                }
            }
        }
        return nums;
    }

    /**
     * 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 示例 2:
     * <p>
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * 说明：
     * <p>
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶:
     * <p>
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     */
    private static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        if (nums1.length < nums2.length) {
            for (int i = 0; i < nums1.length; i++) {
                int k = 0;
                for (int j = k; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        list.add(nums1[i]);
                        break;
                    } else {
                        j++;
                    }
                }
            }
        } else {
            for (int i = 0; i < nums2.length; i++) {
                for (int j = 0; j < nums1.length; j++) {
                    if (nums2[i] == nums1[j]) {
                        list.add(nums2[i]);
                    } else {
                        j++;
                    }
                }
            }
        }

        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }

        return a;
    }


    /**
     * 求众数
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     */

    public static void majorityElement(int[] nums) {

        //先给数组排序，排完序就是最中间那个数。
        Arrays.sort(nums);
        int a = nums[nums.length / 2];
        System.out.println(a);
    }

    /**
     * 《合并两个有序数组》
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * <p>
     * 说明:
     * <p>
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 示例:
     * <p>
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * 输出: [1,2,2,3,5,6]
     */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
        System.out.println(Arrays.toString(nums1));
    }
}
