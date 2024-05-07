import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine){
            if(map.containsKey(t)) map.put(t, map.get(t)+1);
            else map.put(t, 1);
        }
        
         List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Comparator.comparing(Map.Entry::getValue, Collections.reverseOrder()));

        
        int num = 0;
        int answer = 0;
        
        for (Map.Entry<Integer, Integer> entry : entryList) {
            answer++;
            num += entry.getValue();
            if(num >= k) return answer;
        }

        return -1;
    }
}