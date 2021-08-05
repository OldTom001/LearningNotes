package FindRepeatedDnaSequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 线性窗口
 */
public class Solution1 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }

        Set<String> rollWin = new HashSet<>();
        Set<String> output = new HashSet<>();
        int L = 10;
        for (int i = 0; i < s.length() - L + 1; i++) {
            String tmp = s.substring(i, i + L);
            if (rollWin.contains(tmp)) {
                output.add(tmp);
            } else {
                rollWin.add(tmp);
            }

        }
        return new ArrayList<String>(output);
    }

}
