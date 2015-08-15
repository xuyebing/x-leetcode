package roman.to.integer;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author yebingxu
 *
 */
public class Solution {
	
	private Map<Character, Integer> dict = new HashMap<Character, Integer>();
	private void init() {
		dict.put('I', 1);
		dict.put('V', 5);
		dict.put('X', 10);
		dict.put('L', 50);
		dict.put('C', 100);
		dict.put('D', 500);
		dict.put('M', 1000);
	}

	public int romanToInt(String s) {
		if (s == null || s.length() == 0)
			return -1;
        init();
        char[] ca = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < ca.length; i++) {
        	if ((i < ca.length-1) && dict.get(ca[i]) < dict.get(ca[i+1])) {
        		sum += dict.get(ca[i]) * -1;
        	} else {
        		sum += dict.get(ca[i]);
        	}
        }
        return sum;
    }
}
