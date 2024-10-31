import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        PriorityQueue<Integer> qr = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation : operations) {
            String[] input = operation.split(" ");
            
            switch(input[0]){
                case "I":
                    q.add(Integer.parseInt(input[1]));
                    qr.add(Integer.parseInt(input[1]));
                    break;
                    
                case "D":
                    if(q.isEmpty()) continue;
                    int target;
                    if(input[1].equals("1")){
                        target = qr.poll();
                        q.remove(target);
                    } else {
                        target = q.poll();
                        qr.remove(target);
                    }
                    break;
            }
            
        }
        
        int[] answer = new int[2];
        if(q.isEmpty()) return new int[]{0, 0};
        else {
            answer[0] = qr.poll();
            answer[1] = q.poll();
            return answer;
        }
    }
}