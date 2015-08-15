package largest.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * @author yebingxu
 *
 */
public class Solution {

	class NumComparator<T> implements Comparator<T> {

		@Override
		public int compare(T o1, T o2) {
			String str1 = o1.toString();
			String str2 = o2.toString();
			
			if (str1.concat(str2).compareTo(str2.concat(str1)) > 0) {
				return -1;
			} else if (str1.concat(str2).compareTo(str2.concat(str1)) < 0) {
				return 1;
			} else {
				return 0;
			}
		}
		
	}
    public String largestNumber(int[] num) {
    	List<Integer> ilist = new ArrayList<Integer>();
    	for(int a : num) {
    		ilist.add(a);
    	}
        Collections.sort(ilist, new NumComparator<Integer>());
        StringBuilder sb = new StringBuilder();
        for (Integer i : ilist) {
        	sb.append(i);
        }
        if (sb.toString().toCharArray()[0] == '0')
        	return "0";
        return sb.toString();
    }
}
