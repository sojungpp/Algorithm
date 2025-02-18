import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        char[] inputs = dirs.toCharArray();
        boolean[][][] visited = new boolean[11][11][5];
        int answer = 0;
        int x = 5;
        int y = 5;
        for(char input : inputs) {
            switch(input) {
                case 'U':
                    if(isValid(x, y+1)) {
                        if(!visited[x][y][1]) {
                            visited[x][y][1] = true;
                            visited[x][y+1][2] = true;
                            answer++;
                        } y += 1;
                    }
                    break;
                case 'D':
                    if(isValid(x, y-1)) {
                        if(!visited[x][y][2]) {
                            visited[x][y][2] = true;
                            visited[x][y-1][1] = true;
                            answer++;
                        } y -= 1;
                    }
                    break;
                case 'R':
                    if(isValid(x+1, y)) {
                        if(!visited[x][y][4]) {
                            visited[x][y][4] = true;
                            visited[x+1][y][3] = true;
                            answer++;
                        } x += 1;
                    }
                    break;
                case 'L':
                    if(isValid(x-1, y)) {
                        if(!visited[x][y][3]) {
                            visited[x][y][3] = true;
                            visited[x-1][y][4] = true;
                            answer++;
                        } x -= 1;
                    }
                    break;
            }
        }
        return answer;
    }
    
    private boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<=10 && y<=10;
    }
}