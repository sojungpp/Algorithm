import java.util.*;

class Solution {
    
    List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {

        // n개를 1번 -> 3번으로
        dfs(n, 1, 3, 2);
        
        int[][] answer = new int[list.size()][2];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private void dfs(int n, int start, int end, int mid) {
        if(n == 1) {
            list.add(new int[]{start, end});
            return;
        }
        
        
        // 1번의 n-1개를 1번 -> 2번으로
        dfs(n-1, start, mid, end);
        
        // 1번의 n을 1번 -> 3번
        list.add(new int[]{start, end});

        // 2번의 n-1개 1번 -> 3번으로
        dfs(n-1, mid, end, start);
    }
}