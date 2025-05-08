import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int sat = (startday == 7) ? 6 : 6 - startday;
        int sun = 7 - startday;
        
        for(int i=0; i<schedules.length; i++) {
            int hour = schedules[i] / 100;
            int min = schedules[i] % 100 + 10;
            if(min >= 60) {
                hour += 1;
                min -= 60;
            }
            schedules[i] = hour*100 + min;
        }
        
        for(int i=0; i<schedules.length; i++) {
            boolean isPass = true;
            for(int j=0; j<timelogs[i].length; j++) {
                if(j == sat || j == sun) continue;
                if(timelogs[i][j] > schedules[i]) {
                    isPass = false;
                    break;
                }
            }
            if(isPass) answer++;
        }
        
        return answer;
    }
}