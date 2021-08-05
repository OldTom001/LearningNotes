package PartitionLabels;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        if (s.length() == 0) {
            return new ArrayList<>();
        }

        List<Integer> partition = new ArrayList<>();
        int[] lastInd = new int[26];
        int end = 0, start = 0;

        for (int i = 0; i < s.length(); i++) {
            lastInd[s.charAt(i) - 'a'] = i;  //记录s中每个字母最后出现的位置
        }

        for(int i = 0; i<s.length();i++) {
            end = Math.max(lastInd[s.charAt(i) - 'a'], end); //更新end
            if(i==end) {
                partition.add(end-start+1);
                start = end+1;
            }
        }
        return partition;
    }
}
