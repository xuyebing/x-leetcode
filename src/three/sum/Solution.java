package three.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * @author yebingxu
 *
 */
/**
 * For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */

public class Solution {

	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> retList = new ArrayList<List<Integer>> ();
		if (num == null || num.length < 3) {
			return retList;
		}
        Arrays.sort(num); // quick sort the input array
        
        int tgt = 0;
        boolean init = true;
        for (int i = 0; i < num.length - 2; i++) {
        	int a = num[i];
        	if (init) {
        		tgt = 0 - a;
        		init = false;
        	}
        	else {
        		if (tgt == 0 - a) {
        			continue;
        		} else {
        			tgt = 0 - a;
        		}
        	}
    		Set<int[]> tset = find2Sum(num, i+1, num.length-1, tgt);
    		if (tset != null && tset.size() > 0) {
    			for (int[] ia : tset) {
        			List<Integer> list = new ArrayList<Integer>();
        			list.add(a);
        			list.add(ia[0]);
        			list.add(ia[1]);
        			retList.add(list);
    			}
    		}
        }
        return retList;
    }
	
	private Set<int[]> find2Sum(int[] array, int s, int e, int tgt) {
		int i = s;
		int j = e;
		Set<int[]> set = new HashSet<int[]> ();
		int a = 0;
		boolean init = true;
		boolean changeI = true;
		while (i < j) {
			if (init) {
				a = array[i];
				init = false;
			} else {
				if (changeI && (array[i] == a)) {
					i++;
					changeI = true;
					continue;
				} else {
					a = array[i];
				}
			}
			int real = array[i] + array[j];
			if (real == tgt) {
				int[] tmp = new int[2];
				tmp[0] = array[i];
				tmp[1] = array[j];
				set.add(tmp);
				i++;
				changeI = true;
			} else if (real < tgt){
				i++;
				changeI = true;
			} else {
				j--;
				changeI = false;
			}
		}
		return set;
	}
	
	public static void main(String[] args) {
		int[] num = new int[] {-2,0,1,1,2};
		Solution s = new Solution();
		List<List<Integer>> ret = s.threeSum(num);
		for (List<Integer> list : ret) {
			System.out.println(list.get(0) + "," + list.get(1) + "," + list.get(2));
		}
	}
}
