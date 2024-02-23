import java.util.*;

class Solution {
    public int solution(int[] num_list, int n) {
        ArrayList<Integer> nums = new ArrayList<>();
        for(int num : num_list){
            nums.add(num);
        }
        
        if(nums.contains(n)) return 1;
        else return 0;
    }
}