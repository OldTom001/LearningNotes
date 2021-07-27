package SortColors;

import java.util.Arrays;

/*数组中包含0,1,2三种元素, 按顺序排列这三种元素, 要求原地排序, 时间复杂度O(N)
使用双指针+三向切分写法
 */

public class Method {
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,0,2,2,1};
        sortColors(arr);
    }

    public static void sortColors(int[] nums) {
        int len = nums.length;

        int left = 0, right = len-1;
        int i = left;
        int temp;
        while (i<=right) {
            if(nums[i] == 2){
                temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;
            }
            else if(nums[i] == 0) {
                temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
                i++;
            }
            else {
                i++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}

