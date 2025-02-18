import java.util.*;

class Solution {
    public int solution(int storey) {
        
        int answer = 0;
        while(storey != 0) {
            int value = storey%10;
            storey = storey/10;
            if(value == 5) {
                if(storey%10 >= 5) {
                    answer += 10-value;
                    storey += 1;
                } else answer += value;
            }
            else if(value < 5) answer += value;
            else {
                answer += 10-value;
                storey += 1;
            }
        }
        
        return answer;
    }
}