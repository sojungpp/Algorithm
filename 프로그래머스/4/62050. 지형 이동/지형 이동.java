import java.util.*;

class Solution {
    
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int n;
    
    public int solution(int[][] land, int height) {
        n = land.length;
        boolean[][] visited = new boolean[n][n];
        
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.money - b.money);
        q.add(new Node(0, 0, 0));
        
        int answer = 0;
        while(!q.isEmpty()) {
            Node temp = q.poll();
            if(!visited[temp.start][temp.end]) {
                answer += temp.money;
                visited[temp.start][temp.end] = true;
            }
            
            for(int i=0; i<4; i++) {
                int tempX = temp.start+dx[i];
                int tempY = temp.end+dy[i];
                                
                if(isValid(tempX, tempY) && !visited[tempX][tempY]) {
                    int tempHeight = Math.abs(land[tempX][tempY] - land[temp.start][temp.end]);
                    if(tempHeight <= height) {
                        q.add(new Node(tempX, tempY, 0));
                    } else 
                        q.add(new Node(tempX, tempY, tempHeight));
                }
            }
        }
        
        return answer;
    }
    
    private boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<n && y<n;
    }
    
    public class Node {
        int start;
        int end;
        int money;
        
        public Node(int start, int end, int money) {
            this.start = start;
            this.end = end;
            this.money = money;
        }
    }
}