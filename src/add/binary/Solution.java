package add.binary;

/**
 * Created by yebingxu on 6/12/15.
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder("");
        char carry = '0';

        int alen = a.length();
        int blen = b.length();

        int i = alen-1;
        int j = blen-1;
        while (i>=0 && j>=0) {
            int t = a.charAt(i)-'0' + b.charAt(j)-'0' + carry-'0';
            int m = t % 2;
            int ci = t / 2;
            sb.append((char)('0' + m));
            carry = (char)('0' + ci);
            i--;
            j--;
        }
        while (i>=0) {
            int t = a.charAt(i)-'0' + carry-'0';
            int m = t%2;
            int ci = t/2;
            sb.append((char)('0' + m));
            carry = (char)('0' + ci);
            i--;
        }
        while (j>=0) {
            int t = b.charAt(j)-'0' + carry-'0';
            int m = t%2;
            int ci = t/2;
            sb.append((char)('0' + m));
            carry = (char)('0' + ci);
            j--;
        }
        if (carry == '1') {
            sb.append("1");
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "1";
        String b = "1";
        Solution s = new Solution();
        s.addBinary(a,b);
    }
}
