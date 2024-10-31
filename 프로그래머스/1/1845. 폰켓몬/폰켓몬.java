import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        int num = nums.length / 2;
        if(map.size() >= num) return num;
        
        List<Integer> key = new ArrayList<>(map.keySet());
        key.sort((a, b) -> map.get(a) - map.get(b));
        
        int answer = 0;
        for(Integer k : key) {
            num -= 1;
            answer++;
            if(num <= 0) return answer;
        }

        return answer;
    }
}