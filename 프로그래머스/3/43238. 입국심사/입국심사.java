import java.util.*;

class Solution {
    // 한 심사대에서는 한 명만 심사
    // 심사 받는데 걸리는 최소 시간
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = times[0];
        long max = (long)times[times.length-1]*(long)n;
        long mid;
        
        long answer = Long.MAX_VALUE;
        while(min<=max) {
            mid = (min+max)/2;
            long tempSum = 0;
            for(int t : times) {
                tempSum += mid/t;
            }
            if(tempSum >= n) {
                answer = Math.min(answer, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        
        return answer;
    }
}