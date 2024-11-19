import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitQ = new LinkedList<>();
        Queue<int[]> bridgeQ = new LinkedList<>();
        int finishNum = 0;

        for(int t : truck_weights) {
            waitQ.add(t);
        }

        int answer = 0;
        int nowWeight = 0;
        
        while(finishNum != truck_weights.length) {
            answer++;
            
            // 1칸씩 이동
            int standard = bridgeQ.size();
            for(int i=0; i<standard; i++) {
                int[] temp = bridgeQ.poll();
                if(temp[1] == bridge_length) {
                    nowWeight -= temp[0];
                    finishNum++;
                }
                else bridgeQ.add(new int[]{temp[0], temp[1]+1});
            } 
            
            // 다리 건널 수 있으면 추가
            if(bridgeQ.size() < bridge_length && waitQ.size() != 0) {
                if(waitQ.peek() + nowWeight <= weight) {
                    int truck = waitQ.poll();
                    bridgeQ.add(new int[]{truck, 1});
                    nowWeight += truck;
                }
            }
        }
        
        return answer;
    }
}