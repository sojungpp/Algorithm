import java.util.*;

class Solution {
    public int solution(int[] array, int height) {
        
        List<Integer> list = new ArrayList<>();
        for(int num : array){
            list.add(num);
        }
        Collections.sort(list);
        
        int answer = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i) > height) return list.size() - i;
        }
        return answer;
    }
}