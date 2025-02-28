import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>();
        for(String gem : gems) {
            gemSet.add(gem);
        }
        Set<String> tempSet = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        
        int[] answer = new int[2];
        int difference = Integer.MAX_VALUE;
        
        while(right < gems.length) {
            map.put(gems[right], map.getOrDefault(gems[right], 0)+1);
            tempSet.add(gems[right]);
            
            while(map.get(gems[left]) >= 2) {
                map.put(gems[left], map.get(gems[left])-1);
                left++;
            }
            
            if(gemSet.size() == tempSet.size() && right - left < difference) {
                answer[0] = left+1;
                answer[1] = right+1;
                difference = right - left;
            }
            right++;
        }
        
        return answer;
    }
}