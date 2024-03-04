import java.util.*;

class Solution {
    public String solution(String s) {
        String[] values = s.split("");
        Arrays.sort(values);
        String answer = "";

        for(int i=0; i<values.length; i++){
            int count = 0;
            for(int j=0; j<values.length; j++){
                if(values[i].equals(values[j])) count++;
            }
            if(count==1) answer += values[i];
        }
        return answer;
    }
}