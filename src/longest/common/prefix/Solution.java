package longest.common.prefix;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author yebingxu
 *
 */
public class Solution {

	public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
        	return "";
        }
        if (strs.length == 1)
        	return strs[0];
        StringBuilder sb = new StringBuilder();
        String s = strs[0];
        String retPre = "";
        for (int i = 1; i <= s.length(); i++) {
        	String prefix = s.substring(0, i);
        	Boolean find = true;
        	for(int j = 1; j < strs.length; j++) {
        		if (!strs[j].startsWith(prefix)) {
        			find = false;
        			break;
        		}
        	}
        	if (find)
        		retPre = prefix;
        	else
        		return retPre;
        }
        return retPre;
    }
}
