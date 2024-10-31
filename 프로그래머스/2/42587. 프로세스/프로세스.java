import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int p : priorities) {
            q.add(p);
        }
        
        int answer = 0;
        while(true) {
            for(int i=0; i<priorities.length; i++) {
                if(q.peek() == priorities[i]) {
                    q.poll();
                    answer++;
                    if(i == location) return answer;
                }
            }
        }
    }
}