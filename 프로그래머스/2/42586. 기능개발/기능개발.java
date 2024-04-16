import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){
            int percent = 100 - progresses[i];
            if(percent%speeds[i]==0) q.add(percent/speeds[i]);
            else q.add(percent/speeds[i] + 1);
        }
        int standard = q.poll();
        int num = 1;
        while(!q.isEmpty()){
            int temp = q.poll();
            if(temp <= standard) num++;
            else {
                answer.add(num);
                num = 1;
                standard = temp;
            }
        }
        answer.add(num);
        return answer.stream().mapToInt(i->i).toArray();
    }
}