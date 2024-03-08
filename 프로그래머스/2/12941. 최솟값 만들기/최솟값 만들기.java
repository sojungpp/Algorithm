import java.util.*;

class Solution{
    public int solution(int[] A, int[] B){
        int answer = 0;
        PriorityQueue<Integer> qA = new PriorityQueue<>();
        PriorityQueue<Integer> qB = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<A.length; i++){
            qA.add(A[i]);
            qB.add(B[i]);
        }
        
        while(!qA.isEmpty()){
            answer += qA.poll() * qB.poll();    
        }
        return answer;
    }
}