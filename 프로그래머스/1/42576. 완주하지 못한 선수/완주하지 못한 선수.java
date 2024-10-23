import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<participant.length; i++) {
            Integer num = map.getOrDefault(participant[i], 0)+1;
            map.put(participant[i], num);
        }
        
        for(int i=0; i<completion.length; i++) {
            if(map.containsKey(completion[i])){
                if(map.get(completion[i]) == 1) map.remove(completion[i]);
                else map.put(completion[i], map.get(completion[i])-1);
            }
        }
        
        List<String> answer = new ArrayList<>(map.keySet());
        return answer.get(0);
    }
}