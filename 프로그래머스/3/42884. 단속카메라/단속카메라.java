import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        
        int answer = 1;
        
        int[] standard = new int[2];
        standard[0] = routes[0][0];
        standard[1] = routes[0][1];
        for(int i=1; i<routes.length; i++) {
            int targetX = routes[i][0];
            int targetY = routes[i][1];
            
            if(targetX > standard[1]) {
                answer++;
                standard[0] = targetX;
                standard[1] = targetY;
                continue;
            }
            
            if(targetY > standard[1]) {
                standard[0] = targetX;
                continue;
            }
            
            if(targetY < standard[1]) {
                standard[0] = targetX;
                standard[1] = targetY;
                continue;
            }
        }
                
        return answer;
    }
}