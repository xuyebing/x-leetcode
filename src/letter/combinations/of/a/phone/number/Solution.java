package letter.combinations.of.a.phone.number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	private Map<Integer, Character[]> dict = new HashMap<Integer, Character[]> ();
	
	public void init() {
		dict.put(2, new Character[]{'a', 'b', 'c'});
		dict.put(3, new Character[]{'d', 'e', 'f'});
		dict.put(4, new Character[]{'g', 'h', 'i'});
		dict.put(5, new Character[]{'j', 'k', 'l'});
		dict.put(6, new Character[]{'m', 'n', 'o'});
		dict.put(7, new Character[]{'p', 'q', 'r', 's'});
		dict.put(8, new Character[]{'t', 'u', 'v'});
		dict.put(9, new Character[]{'w', 'x', 'y', 'z'});
		dict.put(0, new Character[]{' '});
	}
	
	public List<String> letterCombinations(String digits) {
        List<String> retList = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
        	return retList;
        }
        init();
        char[] ca = digits.toCharArray();
        int index = 0;
        StringBuffer sb = new StringBuffer();
        backTrackingCore(ca, index, sb, retList);
        return retList;
    }
	
	private void backTrackingCore(char[] ca, int index, StringBuffer sb, List<String> retList) {
		if (index == ca.length) {
			retList.add(sb.toString());
			return;
		}
		int a = ca[index] - '0';
		Character[] values = dict.get(a);
		if (values!= null) {
			for (char c : values) {
				sb.append(c);
				backTrackingCore(ca, index+1, sb, retList);
				sb.deleteCharAt(index);
			}
		} else {
			retList = null;
			return;
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String str = "23";
		List<String> ret = s.letterCombinations(str);
		for (String abc : ret) {
			System.out.println(abc);
		}
	}
}
