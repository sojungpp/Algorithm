import java.util.*;

class Solution {
    
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> result = new HashMap<>();
        
        for(String c: completion) {
            if(result.containsKey(c)) result.put(c, result.get(c) + 1);
            else result.put(c, 1);
        }
        
        for(String p: participant) {
            if(!result.containsKey(p)) return p;
            else result.put(p, result.get(p) - 1);
            if(result.get(p) < 0) return p;
        }
        return null;
    }
}