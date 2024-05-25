import java.util.*;

class Solution {
    public int solution(int[] order) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        
        for(int i=1; i<=order.length; i++){
            q.add(i);
        }
        int answer = 0;
        int standard = 0;
        
        // Queue에 저장한 상자 차례로 빼기
        while(!q.isEmpty()){
            // Stack을 싣는 경우
            if(!s.isEmpty() && s.peek() == order[standard]){
                s.pop();
                answer++;
                standard++;
                continue;
            }
            int temp = q.poll();
            // Queue를 바로 싣는 경우
            if(temp == order[standard]){
                answer++;
                standard++;
                continue;
            }
            s.push(temp);
        }
        
        // Stack 최종 체크
        while(!s.isEmpty() && standard != order.length && s.peek() == order[standard]){
            s.pop();
            answer++;
            standard++;
        }
        return answer;
    }
}