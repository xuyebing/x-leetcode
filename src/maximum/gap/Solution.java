package maximum.gap;

import java.util.BitSet;

public class Solution {

    public int maximumGap(int[] num) {
        if (num == null || num.length <= 1)
        	return 0;
        
        int min = num[0];
        int max = num[0];
        for (int i = 1; i < num.length; i++) {
        	if (min > num[i])
        		min = num[i];
        	if (max < num[i])
        		max = num[i];
        }
        BitSet a = new BitSet(max - min + 1);
        for (int i = 0 ; i < max-min+1; i++)
        	a.set(i,false);
        
        for (int i = 0; i < num.length; i++) {
        	a.set(num[i]-min, true);
        }
        int before = 0;
        int maxGap = 0;
        for (int i = 1; i < max-min+1; i++) {
        	if (a.get(i)) {
        		int gap = i - before;
        		if (maxGap < gap)
        			maxGap = gap;
        		before = i;
        	}
        }
        return maxGap;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] a = new int[]{2,99999999};
    	System.out.println(s.maximumGap(a));
    }
}
