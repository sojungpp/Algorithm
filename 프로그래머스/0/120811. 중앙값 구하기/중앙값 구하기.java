import java.util.*;

class Solution {
    public int solution(int[] array) {
        List<Integer> list = new ArrayList<>();
        for(int value : array){
            list.add(value);
        }
        Collections.sort(list);
        
        return list.get(list.size()/2);
    }
}