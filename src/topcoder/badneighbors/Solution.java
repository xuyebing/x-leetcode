package topcoder.badneighbors;

/**
 * @author yebingxu
 */
public class Solution {

    // 使用动态规划
    // 设 dp[i] 表示到下标i为止，最大的donation和
    //    则有: dp[i] = max { dp[i-2] + donations[i], dp[i-1] }
    //    即，dp[i] 等于 当前donations[i]加上dp[i-2](非邻居) 和 dp[i-1](不包含当前的donations[i]) 这两个数中的最大值
    //    由于donations是一个环，即 0 和 n-1 相邻，所以进行两次寻找, /* 解决环的关键是将环切开，分两组区域进行两次寻找，牛! */
    //        1st: 在0 ~ n-2中寻找最大值max1，
    //        2nd: 在1 ~ n-1中寻找最大值max2
    //    最后，返回max1, max2中的大值

    public int maxDonations(int[] donations) {
        if (donations == null || donations.length == 0) {
            return -1;
        }
        int len = donations.length;
        if (len == 1) {
            return donations[0];
        }

        int max1 = findMaxDonation(donations, 0, len-2);
        int max2 = findMaxDonation(donations, 1, len-1);

        return max(max1, max2);
    }

    private int findMaxDonation(int[] donations, int s, int e) {
        if (s > e) {
            return 0;
        }
        if (s == e) {
            return donations[s];
        }
        int[] dp = new int[e+1];
        dp[s] = donations[s]; // base condition

        int maxV = 0;
        for (int i = s+1; i <= e; i++) {
            if (i == s+1) {
                dp[s+1] = donations[s+1];
                continue;
            }
            dp[i] = max(dp[i-1], dp[i-2] + donations[i]);
            maxV = max(maxV, dp[i]);
        }

        return maxV;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] donations = new int[]{ 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
//        int[] donations = new int[]{ 7, 7, 7, 7, 7, 7, 7};
        int[] donations = new int[] {94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
                6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
                52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
        System.out.println(s.maxDonations(donations));
    }
}
