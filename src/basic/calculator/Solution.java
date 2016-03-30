package basic.calculator;

/**
 * @author yebingxu
 */
public class Solution {

    // 思路： 递归

    public int calculate(String s) {
        int sum = 0;
        char operation = '+'; // 默认的计算是加
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (isNumber(s.charAt(i))) {
                int j = findNumLastIndex(s, i);
                sum = compute(operation, sum, Integer.valueOf(s.substring(i,j+1)));
                i = j;
                continue;
            }
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                operation = s.charAt(i);
            }
            if (s.charAt(i) == '(') {
                // find first ')'
                int j = s.indexOf(')');

                int t = calculate(s.substring(i+1,j));
                sum = compute(operation, sum, t);
                i=j;
                continue;
            }
            // 注意，没有在for循环中判断')', 原因是如果没有出现'('的情况下就遇到')',这种情况是不合法的.
        }
        return sum;
    }

    private int findNumLastIndex(String s, int begin) {
        int i = begin;
        while (i < s.length() && isNumber(s.charAt(i))){
            i++;
        }
        return i-1;
    }

    private boolean isNumber(char a) {
        if (a >= '0' && a <= '9') {
            return true;
        }
        return false;
    }

    private int compute(char operation, int a, int b) {
        if (operation == '+') {
            return a + b;
        } else {
            return a - b;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "(1+(4+5+2)-3)+(6+8)";
        s.calculate(str);
    }
}
