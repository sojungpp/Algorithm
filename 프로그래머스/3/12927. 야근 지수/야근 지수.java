import java.util.*;

// 야근 피로도 = 남은 일의 작업량(제곱)

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works) {
            q.add(w);
        }
        
        while(n!=0 && !q.isEmpty()) {
            int temp = q.poll();
            if(temp != 0) {
                q.add(temp-1);
                n--;
            }
        }
        
        long answer = 0;
        while(!q.isEmpty()) {
            answer += Math.pow(q.poll(), 2);
        }

        return answer;
    }
}