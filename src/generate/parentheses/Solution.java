package generate.parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        int l_left = n;
        int r_left = n;
        
        StringBuilder sb = new StringBuilder();
        List<String> retList = new ArrayList<String>();
        funCore(retList, sb, n, l_left, r_left);
        return retList;
    }
    private void funCore(List<String> retList, StringBuilder sb, int n, int left, int right) {
    	if (sb.length() == 2 * n) {
    		retList.add(sb.toString());
    		return;
    	}
    	if (left > 0) {
    		sb.append("(");
    		funCore(retList, sb, n, left-1, right);
    		sb.deleteCharAt(sb.length()-1);
    	}
    	if ((right > 0) && (right > left)) {
    		sb.append(")");
    		funCore(retList, sb, n, left, right-1);
    		sb.deleteCharAt(sb.length()-1);
    	}
    }
}
