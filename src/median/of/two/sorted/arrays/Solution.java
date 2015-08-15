package median.of.two.sorted.arrays;

public class Solution {

	public double findMedianSortedArrays(int A[], int B[]) {
        if (A == null) {
        	if (B == null) {
        		return 0;
        	} else {
        		return B[B.length/2];
        	}
        }
        if (B == null) {
        	return A[A.length/2];
        }
        
        int s1 = 0, e1 = A.length-1;
        int s2 = 0, e2 = B.length-1;
        while ((s1 < e1) || (s2 < e2)) {
        	
        }
        return 0.0;
    }
}
