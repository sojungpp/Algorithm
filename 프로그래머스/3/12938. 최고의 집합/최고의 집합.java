import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            answer[i] = s/n;
        }
        int temp = s%n;
        int index = n-1;
        while(temp != 0) {
            answer[index] += 1;
            index--;
            temp--;
        }
        
        if(answer[0] == 0) return new int[]{-1};
        return answer;
    }
}