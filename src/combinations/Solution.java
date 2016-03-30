package combinations;

import java.util.*;

/**
 * @author yebingxu
 */
public class Solution {

    // 思路：考虑使用动态规划
    // f(n, k) = { f(n-1, k) + f(n-1, k-1) }
    // f(n-1, k)表示不包含最大的数n的所有情况; f(n-1, k-1)表示包含了最大的数n后的所有的情况
    // NOTE: 集合类型的元素进行赋值时，注意使用deep copy

    private Map<String, List<List<Integer>>> memStore = new HashMap<String, List<List<Integer>>>();

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (n < k) {
            return results;
        }
        String key = hashKey(n, k);
        if (memStore.containsKey(key)) {
            List<List<Integer>> copy = deepCopy(memStore.get(key));

            return copy; // 使用copy，如果传引用，则hashMap中保存的值会被修改，切记！
        }
        if (n == k) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            results.add(list);
            memStore.put(key, results); // 保存结果到内存map中

            return results;
        }

        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);

                results.add(list);
            }
            memStore.put(key, results);

            return results;
        }

        List<List<Integer>> rets1 = deepCopy(combine(n-1, k)); // 注意使用深拷贝
        results.addAll(rets1);

        List<List<Integer>> rets2 = deepCopy(combine(n-1, k-1)); // 注意使用深拷贝
        for (List<Integer> list : rets2) {
            list.add(n);
        }
        results.addAll(rets2);

        memStore.put(key, results);

        return results;
    }

    private String hashKey(int n, int k) {
        return n + "," + k;
    }

    private List<List<Integer>> deepCopy(List<List<Integer>> srcs) {
        List<List<Integer>> copy = new ArrayList<List<Integer>>();
        for (List<Integer> src : srcs) {
            List<Integer> clone = new ArrayList<Integer>(src.size());
            for (Integer a : src) {
                clone.add(a);
            }
            copy.add(clone);
        }

        return copy;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        Solution s = new Solution();
        s.combine(5,3);
    }
}
