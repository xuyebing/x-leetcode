import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by yebingxu on 10/12/15.
 */
public class Test {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int l1 = v1.length;
        int l2 = v2.length;
        if (l1 < l2) {
            int t = l2 - l1;
            StringBuilder sb = new StringBuilder();
            sb.append(version1);
            while (t > 0) {
                sb.append(".0");
                t--;
            }
            v1 = sb.toString().split("\\.");
        } else if (l2 < l1) {
            int t = l1 - l2;
            StringBuilder sb = new StringBuilder();
            sb.append(version2);
            while (t > 0) {
                sb.append(".0");
                t--;
            }
            v2 = sb.toString().split("\\.");
        }

        int i = v1.length;

        for (int j = 0; j < i; j++) {
            int r = compare(v1[j], v2[j]);
            if (r != 0) {
                return r;
            }
        }
        return 0;
    }

    private int compare(String str1, String str2) {
        int i = 0;
        while (i < str1.length() && str1.charAt(i)=='0') {
            i++;
        }
        String v1 = "0";
        if (i < str1.length()) {
            v1 = str1.substring(i);
        }
        i = 0;
        while (i < str2.length() && str2.charAt(i) == '0') {
            i++;
        }
        String v2 = "0";
        if (i < str2.length()) {
            v2 = str2.substring(i);
        }

        if (v1.length() < v2.length()) {
            return -1;
        } else if (v1.length() > v2.length()) {
            return 1;
        } else {
            for (i = 0; i < v1.length(); i++) {
                if (v1.charAt(i) - v2.charAt(i) > 0) {
                    return 1;
                } else if (v1.charAt(i) - v2.charAt(i) < 0) {
                    return -1;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.compareVersion("1.0", "1");
    }
}
