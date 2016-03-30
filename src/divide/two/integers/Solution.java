package divide.two.integers;

/**
 * Divide II integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT
 * @author yebingxu
 *
 */

public class Solution {

//	public int divide(int dividend, int divisor) {
//        if (divisor == 0)
//        	return Integer.MAX_VALUE;
//        boolean minus = false;
//        if ((dividend > 0) && (divisor < 0))
//        	minus = true;
//        if ((dividend < 0) && (divisor > 0))
//        	minus = true;
//        int abs_dividend = Math.abs(dividend);
//        int abs_divisor = Math.abs(divisor);
//
//        int i = 0;
//        while (abs_dividend >= abs_divisor) {
//        	i++;
//        	abs_dividend -= abs_divisor;
//        }
//        if (minus)
//        	i *= -1;
//        return i;
//    }

    // 思路：考虑采用右移">>"和减法"-"

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }

        if (divisor == 1) {
            return dividend;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int flag = 1; // 表示是正数还是负数

        long a = (long)dividend, b = (long)divisor;
        // 上面的限制条件保证转为正数时不会溢出
        if (dividend < 0) {
            a *= -1; // 变为正数
            flag *= -1;
        }
        if (divisor < 0) {
            b *= -1; // 变为正数
            flag *= -1;
        }
        if (a < b) {
            return 0;
        }
        // 重点关注 a > b的情况
        long sum = 0;
        int p = 1;
        long b1 = b;
        long x = a;
        while (true) {
            int i = 0; // 记录左移次数
            while (x - b1 >= 0) {
                p = p<<1;
                b1 = b1<<1;
                i++;
            }
            i--;
            sum += (1<<i);

            x = x - (b<<i);
            if (x < b) {
                break;
            }
            p = 1;
            b1 = b;
        }
        int result = (int)sum;
        if (flag < 0) {
            result *= -1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int a = -2147483648;
        int b = 2;
        System.out.println(s.divide(a, b));
    }
}
