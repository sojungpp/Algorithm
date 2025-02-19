import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int n, m;
    
    public int solution(String[] board) {
        
        n = board.length;
        m = board[0].length(); 
        char[][] maps = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] start = new int[2];
        int[] goal = new int[2];
        
        for(int i=0; i<board.length; i++) {
            char[] inputs = board[i].toCharArray();
            for(int j=0; j<inputs.length; j++) {
                maps[i][j] = inputs[j];
                if(inputs[j] == 'R') {
                    start[0] = i;
                    start[1] = j;
                } else if(inputs[j] == 'G') {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;
        
        int answer = -1;
        while(!q.isEmpty()) {
            Node temp = q.poll();

            if(temp.x == goal[0] && temp.y == goal[1]) {
                return temp.num;
            }
            
            for(int i=0; i<4; i++) {
                int tempX = temp.x;
                int tempY = temp.y;
                while(true) {
                    tempX += dx[i];
                    tempY += dy[i];
                    if(!isValid(tempX, tempY) || maps[tempX][tempY] == 'D') {
                        tempX -= dx[i];
                        tempY -= dy[i];
                        break;
                    }
                }
                if(!visited[tempX][tempY]) {
                    visited[tempX][tempY] = true;
                    q.add(new Node(tempX, tempY, temp.num+1));
                }
            }
        }
        return answer;
    }
    
    private boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<n && y<m;
    }
    
    public class Node {
        int x;
        int y;
        int num;
        
        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}