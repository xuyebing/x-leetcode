package count.and.say;

/**
 * Created by yebingxu on 7/23/15.
 */
public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String last = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char number = last.charAt(0);
        for (int i = 1; i < last.length(); i++) {
            if (last.charAt(i) == number) {
                count++;
            } else {
                sb.append("" + count).append(number);
                number = last.charAt(i);
                count = 1;
            }
        }
        sb.append("" + count).append(number);
        return sb.toString();
    }
}
