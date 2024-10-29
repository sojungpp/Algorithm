import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        boolean[] isLost = new boolean[n+1];
        Set<Integer> set = new HashSet<>();
        
        for(int l : lost) {
            isLost[l] = true;
        }
        
        for(int r : reserve) {
            if(isLost[r]) {
                set.add(r);
                isLost[r] = false;
            }
        }
        
        Arrays.sort(reserve);
        for(int num : reserve) {
            if(set.contains(num)) continue;
            else if(num-1>0 && isLost[num-1]) isLost[num-1] = false;
            else if(num+1<=n && isLost[num+1]) isLost[num+1] = false;
        }
        
        int answer = n;
        for(int i=1; i<=n; i++) {
            if(isLost[i]) answer -= 1;
        }

        return answer;
    }
}