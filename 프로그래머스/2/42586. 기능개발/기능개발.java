import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<speeds.length; i++) {
            int value = 100 - progresses[i];
            int work = 0;
            if(value % speeds[i] == 0) work = value / speeds[i];
            else work = value / speeds[i] + 1;
            q.add(work);
        }
        
        List<Integer> answer = new ArrayList<>();
        int day = q.poll();
        
        int cnt = 1;
        while(!q.isEmpty()) {
            int temp = q.poll();
            if(temp <= day) cnt++;
            else {
                answer.add(cnt);
                cnt = 1;
                day = temp;
            }
        }
        
        answer.add(cnt);
        return answer.stream().mapToInt(i->i).toArray();
    }
}