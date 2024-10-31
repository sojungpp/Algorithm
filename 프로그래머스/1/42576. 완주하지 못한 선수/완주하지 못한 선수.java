import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<>();
        for(String p : participant) {
            map.put(p, map.getOrDefault(p, 0)+1);
        }
        
        for(String c : completion) {
            if(!map.containsKey(c)) return c;
            
            if(map.get(c)-1 == 0) map.remove(c);
            else map.put(c, map.get(c)-1);
        }
        
        List<String> key = new ArrayList<>(map.keySet());
        return key.get(0);
    }
}