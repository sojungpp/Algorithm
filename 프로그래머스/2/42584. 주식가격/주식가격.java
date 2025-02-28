import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Queue<Integer> q = new LinkedList<>();
        for(int price : prices) {
            q.add(price);
        }
        
        int idx = 0;
        while(!q.isEmpty()) {
            int target = q.poll();
            for(int i=prices.length - q.size(); i<prices.length; i++) {
                if(target > prices[i]) {
                    answer[idx]++;
                    break;
                } else {
                    answer[idx]++;
                }
            }
            idx++;
        }
        
        return answer;
    }
}