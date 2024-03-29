import java.util.*;

class Solution {
    public int solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : array){
            if(map.containsKey(a)) map.put(a, map.get(a)+1);
            else map.put(a, 1);
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
entryList.sort(Map.Entry.comparingByValue());
        
        int answer = entryList.get(entryList.size()-1).getKey();
        if(entryList.size()!=1 && entryList.get(entryList.size()-1).getValue() == entryList.get(entryList.size()-2).getValue()) return -1;
        return answer;
    }
}