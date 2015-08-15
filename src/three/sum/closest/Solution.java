package three.sum.closest;

import java.util.Arrays;

/**
 * Given an array S of n integers,
 * find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * @author yebingxu
 *
 *  For example, given array S = {-1 2 1 -4}, and target = 1.
 *  The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 */
public class Solution {

	public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
        	return -1;
        }
        Arrays.sort(num);
        int min = -1;
        int d = 0;
        boolean init = true;
        int a = 0;
        for (int i = 0; i < num.length - 2; i++) {
        	if (init) {
        		a = num[i];
        	} else {
        		if (a == num[i])
        			continue;
        		else
        			a = num[i];
        	}
        	int tgt = target - num[i];
        	int diff = find2SumClosest(num, i+1, num.length-1, tgt);
        	int tmin = Math.abs(diff);
        	if (min < 0) {
        		min = tmin;
        		d = diff;
        	} else {
        		if (tmin < min) {
        			min = tmin;
        			d = diff;
        		}
        	}
        }
        return target - d;
    }
	
	private int find2SumClosest(int[] num, int s, int e, int tgt) {
		int i = s;
		int j = e;
		boolean init = true;
		boolean changeI = false;
		int a = 0;
		int min = -1;
		int d = 0;
		while ( i < j ) {
			if (init) {
				a = num[i];
				init = false;
			} else {
				if (changeI && (a == num[i])) {
					i++;
					changeI = true;
					continue;
				} else {
					a = num[i];
				}
			}
			int tmp = num[i] + num[j];
			int diff = tgt - tmp;
			if (min < 0) {
				min = Math.abs(diff);
				d = diff;
			} else {
				int t1 = Math.abs(diff);
				if (t1 < min) {
					min = t1;
					d = diff;
				}
			}
			if (diff == 0)
				return 0;
			else if (diff > 0) {
				i++;
				changeI = true;
			} else {
				j--;
				changeI = false;
			}
		}
		return d;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] a = new int[] {4,0,5,-5,3,3,0,-4,-5};
		int sum = -2;
		System.out.println(s.threeSumClosest(a, sum));
	}
}
