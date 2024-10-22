import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int s : scoville) {
            q.add(s);
        }
        
        int answer = 0;
        while(q.size() > 1) {
            int temp = q.poll();
            if(temp >= K) continue;
            
            answer++;
            int secondTemp = q.poll();
            q.add(temp + (secondTemp * 2));
        }
        
        if(q.poll() < K) return -1;
        return answer;
    }
}