import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> map.get(b) - map.get(a));
        
        int answer = 0;
        for(int i=0; i<keys.size(); i++) {
            int num = map.get(keys.get(i));
            k -= num;
            answer++;
            
            if(k<=0) return answer;
        }
        
        return answer;
    }
}