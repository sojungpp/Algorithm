import java.util.*;

class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int min = Integer.parseInt(nums[0]);
        int max = Integer.parseInt(nums[0]);
        
        for(String num : nums) {
            int value = Integer.parseInt(num);
            min = Math.min(value, min);
            max = Math.max(value, max);
        }

        return String.valueOf(min) + " " + String.valueOf(max);
    }
}