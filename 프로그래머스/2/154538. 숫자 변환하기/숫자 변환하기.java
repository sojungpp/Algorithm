import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, 0});
        boolean[] visited = new boolean[10000001];
        // visited[x] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int cnt = now[1];

            if(nowX == y){
                return cnt;
            }
            
            if(nowX+n<=y && !visited[nowX+n]){
                q.add(new int[]{nowX+n, cnt+1});
                visited[nowX+n]=true;
            }
            if(nowX*2<=y && !visited[nowX*2]){
                q.add(new int[]{nowX*2, cnt+1});
                visited[nowX*2]=true;
            }
            if(nowX*3<=y && !visited[nowX*3]){
                q.add(new int[]{nowX*3, cnt+1});
                visited[nowX*3]=true;
            }
        }
        return -1;
    }
}