import java.util.*;

class Solution {
    // n = 처음 병사 수, k = 무적권 수, enemy = 적 수
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        int answer = k;
        
        if(k >= enemy.length) return enemy.length;
        // 무적권을 무조건 쓴다고 가정하고, 적의 수 우선순위 큐에 저장
        for(int i=0; i<k; i++) {
            pq.add(enemy[i]);
        }
        
        // 최소값을 병사로 막고, 추가 라운드를 무적권 사용
        for(int i=k; i<enemy.length; i++) {
            pq.add(enemy[i]);
            int temp = pq.poll();
            if(n < temp) break;
            n -= temp;
            answer++;
        }
        
        return answer;
    }
}