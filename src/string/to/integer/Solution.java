package string.to.integer;

public class Solution {

	public boolean valid = true;
    public int atoi(String str) {
    	boolean minus = false;
        if (str == null || str.length() == 0) {
            valid = false;
            return 0;
        }
        str = str.trim();
        char[] ca = str.toCharArray();
        int s = 0;
        if (ca[0] == '+')
        	s++;
        if (ca[0] == '-') {
        	minus = true;
        	s++;
        }
        Double sum = 0.0;
        for (int i = s; i < str.length(); i++) {
        	
        	if (ca[i] >= '0' && ca[i] <= '9') {
        		double tmp = sum * 10 + (ca[i] - '0');
        		if ((tmp-(tmp%10))/10 != sum) { // overflow
        			valid = false;
        			return 0;
        		}
        		sum = tmp;
        	} else {
        		break;
        	}
        }
        if (minus) {
        	sum *= -1;
        	if (sum < Integer.MIN_VALUE) {
        		return Integer.MIN_VALUE;
        	}
        } else {
        	if (sum > Integer.MAX_VALUE) {
        		return Integer.MAX_VALUE;
        	}
        }
        
        return sum.intValue();
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	s.atoi("-2147483648");
    }
}
