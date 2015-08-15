package divide.two.integers;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT
 * @author yebingxu
 *
 */

public class Solution {

	public int divide(int dividend, int divisor) {
        if (divisor == 0)
        	return Integer.MAX_VALUE;
        boolean minus = false;
        if ((dividend > 0) && (divisor < 0))
        	minus = true;
        if ((dividend < 0) && (divisor > 0))
        	minus = true;
        int abs_dividend = Math.abs(dividend);
        int abs_divisor = Math.abs(divisor);
        
        int i = 0;
        while (abs_dividend >= abs_divisor) {
        	i++;
        	abs_dividend -= abs_divisor;
        }
        if (minus)
        	i *= -1;
        return i;
    }
}
