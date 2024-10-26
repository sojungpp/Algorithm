
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int s : scoville) {
            q.add(s);
        }
        
        int answer = 0;
        while(!q.isEmpty()) {
            int temp = q.poll();
            if(temp >= K) continue;
            
            if(q.isEmpty()) return -1; 
            temp = temp + (q.poll() * 2);
            q.add(temp);
            answer++;
        }
        
        return answer;
    }
}