import java.util.*;

class Solution {
    public int solution(int[] citations) {        
         citations = Arrays.stream(citations)
             .boxed().sorted(Collections.reverseOrder())
             .mapToInt(Integer::intValue).toArray();

        int answer = 0;
        if(citations[0] == 0) return 0;
        for(int i=0; i<citations.length; i++){
            if(citations[i] > i) 
                answer++;
        }
        
        return answer == 0 ? citations.length : answer;
    }
}