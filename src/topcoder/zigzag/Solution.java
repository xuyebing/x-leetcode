package topcoder.zigzag;

/**
 * @author yebingxu
 */
public class Solution {

    public int longestZigZag(int[] nums) {
        int len = nums.length;
        int[] f1 = new int[len]; // 保存以nums[n]作为降序的zigzag最大长度
        int[] f2 = new int[len]; // 保存以nums[n]作为升序的zigzag最大长度

        f1[0] = 1;
        f2[0] = 1;

        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if ((nums[i] < nums[j])   /* 确保到nums[i] 是降序 */
                        && (f2[j]+1 > f1[i])) {
                    f1[i] = f2[j]+1;
                    max = max < f1[i] ? f1[i] : max;
                }
                if ((nums[i] > nums[j])   /* 确保到nums[i] 是升序 */
                        && (f1[j]+1 > f2[i])) {
                    f2[i] = f1[j]+1;
                    max = max < f2[i] ? f2[i] : max;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32};
//        int[] nums = new int[]{374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
//                600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
//                67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
//                477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
//                249, 22, 176, 279, 23, 22, 617, 462, 459, 244};
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9 };
//        int[] nums = new int[] { 1, 7, 4, 9, 2, 5};
//        int[] nums = new int[] {1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
//        int[] nums = new int[]{44};

        System.out.println(s.longestZigZag(nums));
    }
}
