package a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private List<List<Integer>> rList = new ArrayList<List<Integer>>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return rList;
        }
        // sort
        Arrays.sort(nums);

        int before = Integer.MIN_VALUE;
        int len = nums.length;
        List<Integer> tList = new ArrayList<Integer>();
        for (int i = 0; i < len-3; i++) {
            if (i == 0) {
                tList.add(nums[i]);
                find3Sum(nums, i + 1, tList, target - nums[i]);
                tList.remove(0);
                before = nums[i];
            } else {
                if (nums[i] == before) {
                    continue;
                } else {
                    tList.add(nums[i]);
                    find3Sum(nums, i + 1, tList, target - nums[i]);
                    tList.remove(0);
                    before = nums[i];
                }
            }
        }

        return rList;
    }

    private void find3Sum(int[] nums, int start, List<Integer> tList, int target) {
        int before = Integer.MIN_VALUE;
        for (int i = start; i < nums.length - 2; i++) {
            if (i == start) {
                tList.add(nums[i]);
                int newTarget = target - nums[i];
                find2Sum(nums, i + 1, tList, newTarget);
                tList.remove(1); // remove nums[i]
                before = nums[i];
            } else {
                if (nums[i] == before) {
                    continue;
                } else {
                    tList.add(nums[i]);
                    int newTarget = target - nums[i];
                    find2Sum(nums, i + 1, tList, newTarget);
                    tList.remove(1);
                    before = nums[i];
                }
            }
        }
    }

    private void find2Sum(int[] nums, int start, List<Integer> tList, int target) {
        int i = start;
        int j = nums.length-1;
        while (i < j) {
            int tmp = nums[i] + nums[j];
            if (tmp == target) {
                List<Integer> newList = new ArrayList<Integer>();
                newList.addAll(tList);
                newList.add(nums[i]);
                newList.add(nums[j]);

                rList.add(newList);

                // remove duplicate nums[i]
                while (i+1 < nums.length) {
                    if (nums[i+1] == nums[i]) {
                        i++;
                    } else {
                        break;
                    }
                }
                // remove duplicate nums[j]
                while (j-1 >= start) {
                    if (nums[j-1] == nums[j]) {
                        j--;
                    } else {
                        break;
                    }
                }
            } else if (tmp < target) {
                i++;
            } else {
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{2,1,0,-1};
        int target = 2;

        Solution s = new Solution();
        s.fourSum(arrays, target);
    }
}