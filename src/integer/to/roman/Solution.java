package integer.to.roman;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author yebingxu
 *
 */
public class Solution {

	Map<Integer, String[]> dict = new HashMap<Integer, String[]> ();
	private void init() {
		dict.put(1000, new String[]{"M"});
		dict.put(100, new String[]{"C", "D", "M"});
		dict.put(10, new String[]{"X", "L", "C"});
		dict.put(1, new String[]{"I", "V", "X"});
	}
	public String intToRoman(int num) {
        init();
        int tmp = num;
        if (tmp < 1 || tmp > 3999)
        	return "";
        int i = 1000;
        StringBuilder sb = new StringBuilder();
        while (i > 0) {
        	int a = tmp / i;
        	tmp = tmp % i;
        	switch (a) {
	        	case 1:
	        		sb.append(dict.get(i)[0]);
	        		break;
	        	case 2:
	        		sb.append(dict.get(i)[0]).append(dict.get(i)[0]);
	        		break;
	        	case 3:
	        		for (int j = 0; j < 3; j++)
	        			sb.append(dict.get(i)[0]);
	        		break;
	        	case 4:
	        		sb.append(dict.get(i)[0]).append(dict.get(i)[1]);
	        		break;
	        	case 5:
	        		sb.append(dict.get(i)[1]);
	        		break;
	        	case 6:
	        		sb.append(dict.get(i)[1]).append(dict.get(i)[0]);
	        		break;
	        	case 7:
	        		sb.append(dict.get(i)[1]).append(dict.get(i)[0]).append(dict.get(i)[0]);
	        		break;
	        	case 8:
	        		sb.append(dict.get(i)[1]).append(dict.get(i)[0]).append(dict.get(i)[0]).append(dict.get(i)[0]);
	        		break;
	        	case 9:
	        		sb.append(dict.get(i)[0]).append(dict.get(i)[2]);
	        		break;
	        	default:
	        		break;
        	}
        	i /= 10;
        }
        return sb.toString();
    }
}
