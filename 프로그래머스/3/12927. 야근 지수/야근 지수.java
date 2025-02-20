import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works) {
            q.add(w);
        }
        
        for(int i=0; i<n; i++) {
            if(q.isEmpty()) return 0;
            int temp = q.poll();
            if(temp-1 <= 0) continue;
            else q.add(temp-1);
        }
        
        while(!q.isEmpty()) {
            int value = q.poll();
            answer += Math.pow(value, 2);
        }
        
        return answer;
    }
}