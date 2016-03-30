package word.ladder.II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yebingxu
 */
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        return findLaddersCore(beginWord, endWord, wordList, true);
    }

    private List<List<String>> findLaddersCore(String bw, String ew, Set<String> wlist, boolean first) {
        if (!first && editLenIsOne(bw, ew)) {
            ArrayList<String> innerList = new ArrayList<String>();
            innerList.add(bw);
            innerList.add(ew);

            List<List<String>> outerList = new ArrayList<List<String>>();
            outerList.add(innerList);
            return outerList;
        }
        if (wlist == null || wlist.size() == 0) {
            return null;
        }
        List<List<String>> retList = null;
        int minLen = Integer.MAX_VALUE;
        for (String w : wlist) {
            if (editLenIsOne(bw, w)) {
                Set<String> nwList = new HashSet<String>(wlist);
                nwList.remove(w);
                List<List<String>> rList = findLaddersCore(w, ew, nwList, false);
                if (rList != null) {
                    for (List<String> tl : rList) {
                        tl.add(0, bw);
                        if (tl.size() == minLen) {
                            retList.add(tl);
                        } else if (tl.size() < minLen) {
                            minLen = tl.size();
                            retList = new ArrayList<List<String>>();
                            retList.add(tl);
                        }
                    }
                }
            }
        }
        return retList;
    }

    private boolean editLenIsOne(String t, String a) {
        int editLen = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != a.charAt(i)) {
                if ((++editLen) > 1) {
                    return false;
                }
            }
        }
        return editLen == 1 ? true : false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String bw = "qa", ew = "sq";
        Set<String> wlist = new HashSet<String>();
        String[] sarr = new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av",
                "sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow",
                "sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur",
                "rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge",
                "th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di",
                "hi","qa","pi","os","uh","wm","an","me","mo","na","la","st",
                "er","sc","ne","mn","mi","am","ex",
                "pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        for (String word : sarr) {
            wlist.add(word);
        }

        List<List<String>> retList = s.findLadders(bw, ew, wlist);
        if (retList != null) {
            for (List<String> list : retList) {
                for (String str : list) {
                    System.out.print(str + " ");
                }
                System.out.println("");
            }
        }
    }
}