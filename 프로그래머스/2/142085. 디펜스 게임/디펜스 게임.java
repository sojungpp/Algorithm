import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        // n  = 병사 수
        // enemy[i] = 적의 수
        // 남은 병사 수 > 현재 라운드 적의 수 = 게임 종료
        // 무적권(소모 없이 한 라운드 공격 막음) = k번
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        for(int i=0; i<enemy.length; i++) {
            pq.add(enemy[i]);
            if(n - enemy[i] < 0) {
                while(true) {
                    if(n - enemy[i] >= 0) break;
                    
                    if(k <= 0) return answer;
                    if(pq.isEmpty()) return answer;
                    
                    int temp = pq.poll();
                    n += temp;
                    k--;
                }
            }
            
            n -= enemy[i];
            answer++;
        }
        return answer;
    }
}