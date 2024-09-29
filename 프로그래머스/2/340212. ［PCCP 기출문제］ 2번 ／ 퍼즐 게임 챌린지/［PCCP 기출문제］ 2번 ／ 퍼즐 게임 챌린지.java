import java.util.*;

class Solution {
    int[] diffs, times;
    long limit;
    
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
        int right = Arrays.stream(diffs).max().getAsInt();
        int left = 1;
        
        while(left <= right) {
            int mid = (right+left) / 2;
            if(isPossible(mid)) right = mid - 1;
            else left = mid + 1;
        }
        
        return left;
    }
    
    private boolean isPossible(int level) {
        long sum = 0;
        sum += times[0];
        for(int i=1; i<diffs.length; i++) {
            if(diffs[i] <= level) sum += times[i];
            else {
                sum += (times[i-1] + times[i]) * (diffs[i] - level) + times[i];
            }
            if(sum > limit){
                return false;
            }
            if(i == diffs.length-1) {
                return true;
            }
        }
        return false;
    }
}