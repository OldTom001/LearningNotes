package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int len = nums.length;
        if(len < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> threeSumSolution = new ArrayList<>();
        Arrays.sort(nums); //升序排列

        for(int i = 0; i<len-2; i++) {

            if((i != 0)&&(nums[i] == nums[i-1])) {
                continue;
            }

            int big = len-1; //双指针之一，从大到小搜索

            for(int j = i+1; j<len-1;j++) {  //一个指针从前向后移动
                if((nums[j] == nums[j-1])&&(j != i+1)) {
                    continue;
                }
                while ((nums[i] + nums[j] + nums[big]>0)&&big>j) {
                    big--; //一个指针从后向前移动
                }
                if(big == j) {
                    break;
                }
                if(nums[i] + nums[j] + nums[big] == 0) {
                    List<Integer> oneSolution = new ArrayList<>();

                        oneSolution.add(nums[i]);
                        oneSolution.add(nums[j]);
                        oneSolution.add(nums[big]);

                        threeSumSolution.add(oneSolution);
                }

            }
        }
        System.out.println(threeSumSolution);
        return threeSumSolution;
    }
}
