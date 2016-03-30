package fraction.to.recurring.decimal;

import java.util.*;

/**
// * Created by yebingxu on 6/11/15.
// */
//public class Solution {
//    public String fractionToDecimal(int numerator, int denominator) {
//
//        boolean minus = false;
//        if (numerator * denominator < 0) {
//            minus = true;
//        }
//
//        numerator = Math.abs(numerator);
//        denominator = Math.abs(denominator);
//
//        StringBuilder sb = new StringBuilder("");
//        Map<Integer, Integer> dMap= new HashMap<Integer, Integer>();
//        int before = 0;
//        int after = 0;
//        if (numerator >= denominator) {
//            before = numerator / denominator;
//            numerator = numerator - before * denominator;
//        }
//        String result = ""+before;
//        while (numerator != 0) {
//            if (dMap.containsKey(numerator)) {
//                sb.insert(dMap.get(numerator), "(");
//                sb.append(")");
//                break;
//            } else {
//                numerator *= 10;
//                int d = numerator / denominator;
//                sb.append("" + d);
//                dMap.put(numerator/10, sb.toString().length() - 1);
//                numerator = numerator - d * denominator;
//            }
//        }
//        if (sb.toString().isEmpty()) {
//            if (Integer.parseInt(result)!=0 && minus) {
//                result = "-" + result;
//            }
//            return result;
//        } else {
//            if (minus) {
//                result = "-" + result;
//            }
//            return result + "." + sb.toString();
//        }
//    }
//
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(s.fractionToDecimal(1, 333));
//    }
//}

public class Solution {

    // 思路： 核心是判断是否出现重复，使用一个Map来记录整个除法过程。
    // Map的key为商和余数的拼接，value为商在保存商的列表中的索引。
    // 当再次出现相同的商和余数时，查Map得到重复开始的索引，在这个索引前加”(“, 在商的列表最后加”)” 即可

    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return null;
        }
        if (numerator == 0) {
            return "0";
        }
        // if (denominator == 1) {
        //     return String.valueOf(numerator);
        // }
        long a = numerator;
        long b = denominator;
        int flag = 1; // 标志是正数还是负数
        if (a < 0) {
            a = -1 * a; // 如果分母是负数，将它转为正数
            flag *= -1;
        }
        if (b < 0) {
            b = -1 * b; // 如果分子是负数，将它转为正数
            flag *= -1;
        }

        long m = a/b; // 小数点前的结果
        long n = a % b; // 开始计算小数

        boolean hasRecurring = false;
        int recurringBegin = -1;
        Map<String, Integer> appearance = new HashMap<String, Integer>(); // key: 商+","+余数; value: 在decimalPart中的索引
        List<Integer> decimalPart = new ArrayList<Integer>();
        while (n != 0) {
            a = n * 10;
            int t = (int)(a / b);
            n = a % b;
            String k = t + "," + n;
            if (appearance.containsKey(k)) {
                // 出现循环
                hasRecurring = true;
                recurringBegin = appearance.get(k);
                break;
            }
            decimalPart.add(t);
            appearance.put(k, decimalPart.size()-1);
        }

        StringBuilder sb = new StringBuilder();
        if (flag < 0) {
            // 负数，sb添加负号
            sb.append("-");
        }
        if (hasRecurring) {
            sb.append(m+"").append(".");
            for (int i = 0; i < decimalPart.size(); i++) {
                if (i == recurringBegin) {
                    sb.append("(");
                }
                sb.append(""+decimalPart.get(i));
                if (i == decimalPart.size()-1) {
                    sb.append(")");
                }
            }
        } else {
            if (decimalPart.size() > 0) {
                sb.append(""+m).append(".");
                for (int i : decimalPart) {
                    sb.append(""+i);
                }
            } else {
                sb.append(""+m);
            }
        }
        return sb.toString();
    }
}