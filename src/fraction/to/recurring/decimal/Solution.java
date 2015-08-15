package fraction.to.recurring.decimal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yebingxu on 6/11/15.
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        boolean minus = false;
        if (numerator * denominator < 0) {
            minus = true;
        }

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        StringBuilder sb = new StringBuilder("");
        Map<Integer, Integer> dMap= new HashMap<Integer, Integer>();
        int before = 0;
        int after = 0;
        if (numerator >= denominator) {
            before = numerator / denominator;
            numerator = numerator - before * denominator;
        }
        String result = ""+before;
        while (numerator != 0) {
            if (dMap.containsKey(numerator)) {
                sb.insert(dMap.get(numerator), "(");
                sb.append(")");
                break;
            } else {
                numerator *= 10;
                int d = numerator / denominator;
                sb.append("" + d);
                dMap.put(numerator/10, sb.toString().length() - 1);
                numerator = numerator - d * denominator;
            }
        }
        if (sb.toString().isEmpty()) {
            if (Integer.parseInt(result)!=0 && minus) {
                result = "-" + result;
            }
            return result;
        } else {
            if (minus) {
                result = "-" + result;
            }
            return result + "." + sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fractionToDecimal(1, 333));
    }
}
