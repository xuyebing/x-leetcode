package coin.change;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yebingxu
 */
public class Solution {

    // 思路：动态规划
    // f(n, total) = min{f(n-1, total), f(n, total-coins[n])+1}

    private Map<String, Integer> map = new HashMap<String, Integer>();

    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        return core(coins, len, amount);
    }

    private int core(int[] coins, int len, int amount) {
        if (amount == 0) {
             return 0;
        }
        if (amount < coins[0]) {
            return -1;
        }
        String key = getKey(len, amount);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (len == 1) {
            if (amount % coins[0] == 0) {
                int number = amount/coins[0];
                map.put(key, number);
                return number;
            } else {
                // 不存在当前这种
                map.put(key, -1);
                return -1;
            }
        }
        int val = min(core(coins, len-1, amount), core(coins, len, amount-coins[len-1])+1);
        map.put(key, val);
        return val;
    }

    private int min(int a, int b) {
        if (a == -1) {
            if (b > 0) {
                return b;
            } else {
                return -1;
            }
        } else {
            if (b > 0) {
                return (a > b) ? b : a;
            } else {
                return a;
            }
        }
    }

    private String getKey(int n, int amount) {
        return n + "," + amount;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] coins = new int[]{1,2,5};
        s.coinChange(coins, 11);
    }
}
