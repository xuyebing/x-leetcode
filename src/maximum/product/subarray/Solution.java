//package maximum.product.subarray;
//
//public class Solution {
//
//	public int maxProduct(int[] A) {
//        if (A == null || A.length == 0) {
//        	return 0;
//        }
//        int max = Integer.MIN_VALUE;
//        boolean init = true;
//        int[] negA = new int[A.length];
//        int[] posA = new int[A.length];
//
//        if (A[0] < 0) {
//        	negA[0] = A[0];
//        } else {
//        	posA[0] = A
//        }
//        for (int i = 1; i < A.length; i++) {
//        	f[i] = (f[i-1]*A[i] > A[i]) ? f[i-1]*A[i] : A[i];
//        }
//        for (int i : f) {
//        	if (init) {
//        		max = i;
//        		init = false;
//        	} else {
//        		if (max < i) {
//        			max = i;
//        		}
//        	}
//        }
//        return max;
//    }
//
//	public static void main(String[] args) {
//		Solution s = new Solution();
//		int [] A = new int[] {-4,-3,-2};
//		s.maxProduct(A);
//	}
//}
