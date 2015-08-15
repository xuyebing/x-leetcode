package reverse.integer;

public class Solution {
    public int reverse(int x) {
        boolean minus = false;
        int t = x;
        if (t < 0) {
            minus = true;
            t *= -1;
        }
        int rint = 0;
        while (t != 0) {
           int a = t%10;
           t = t/10;
           int tmp = rint * 10 + a;
           if (tmp/10 != rint)
            return 0;
           else
                rint = tmp;
        }
        if (minus)
            rint *= -1;
        return rint;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int x = 1534236469;
    	int ret = s.reverse(x);
    	System.out.println("ret = "+ ret);
    }
}