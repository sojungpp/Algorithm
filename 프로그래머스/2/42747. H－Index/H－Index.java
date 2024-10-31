import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        int n = citations.length;
        int answer = 0;

        for(int i=0; i<citations.length; i++) {
            if(n-i >= citations[i]) answer = citations[i];
            else {
                while(true) {
                    if(n-i <= answer) break;
                    answer++;
                }
                break;
            }
        }
        
        return answer;
    }
}