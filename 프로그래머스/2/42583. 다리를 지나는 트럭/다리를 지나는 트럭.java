import java.util.*;

class Solution {
    
    int weight, length;
    
    private boolean isValid(int bridgeSize, int bridgeWeight){
        return bridgeSize <= length && bridgeWeight <= weight;
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int finishNum = 0;
        this.weight = weight;
        this.length = bridge_length;
        Queue<Integer> q = new LinkedList<>();
        for(int t : truck_weights){
            q.add(t);
        }
        Queue<int[]> bridge = new LinkedList<>();
        int nowWeight = 0;
        
        while(finishNum != truck_weights.length){
            answer++;
            
            // 대기 초 증가
            int num = bridge.size();
            for(int i=0; i<num; i++){
                int[] temp = bridge.poll();
                temp[1] = temp[1] + 1;
                if(temp[1] == bridge_length+1){
                    nowWeight -= temp[0];
                    finishNum++;
                }
                else bridge.add(temp);
            }
            
            // 다리 올라갈 수 있으면 추가
            if(!q.isEmpty() && isValid(bridge.size()+1, nowWeight+q.peek())){
                int temp = q.poll();
                bridge.add(new int[]{temp, 1});
                nowWeight += temp;
            }   
        }
        return answer;
    }
}