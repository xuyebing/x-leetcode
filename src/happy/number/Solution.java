package happy.number;

/**
 * @author yebingxu
 */
public class Solution {
    public boolean isHappy(int n) {
        if (n < 10) {
            if (n == 1 || n == 7) { // 观察1 到 9，发现只有1和7是happy number.
                // 所有算到个位的数，如果结果是1或7，则说明是happy number
                return true;
            } else {
                return false;
            }
        }
        return isHappy(nextN(n));
    }
    private int nextN(int n) {
        int sum = 0;
        while (n > 0) {
            int i = n%10;
            sum += i*i;
            n /= 10;
        }
        return sum;
    }
}
