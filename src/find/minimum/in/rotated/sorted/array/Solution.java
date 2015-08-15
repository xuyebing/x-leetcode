package find.minimum.in.rotated.sorted.array;

public class Solution {

	boolean valid = true;
	public int findMin(int[] num) {
        if (num == null || num.length == 0) {
        	valid = false;
        	return -1;
        }
        if (num[0] < num[num.length-1])
        	return num[0];
        int i = 0;
        int j = num.length - 1;
        while (i < j) {
        	int k = (i+j)/2;
        	if (num[k] < num[0]) {
        		j = k - 1;
        	} else {
        		i = k + 1;
        	}
        }
        return num[i];
    }
}
