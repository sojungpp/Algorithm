import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : numbers) list.add(num);
        
        Collections.sort(list);
        
        return list.get(list.size()-1) * list.get(list.size()-2);
    }
}