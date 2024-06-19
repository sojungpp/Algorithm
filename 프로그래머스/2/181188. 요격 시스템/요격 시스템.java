import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        
        // 끝나는점 기준 오름차순 정렬 
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

        int standard = targets[0][1];
        for(int[] t: targets){
            // 시작점이 기준보다 큰 경우 새로운 요격 필요
            if(standard <= t[0]){
                standard = t[1];
                answer++;
            }
        }
        return answer;
    }
}