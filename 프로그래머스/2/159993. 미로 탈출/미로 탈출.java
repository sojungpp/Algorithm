import java.util.*;

class Solution {
    static int answer = 0;
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int solution(String[] maps) {

        int[] start = new int[2];
        int[] handle = new int[2];
        int[] end = new int[2];
        
        map = new String[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++) {
            String[] input = maps[i].split("");
            for(int j=0; j<input.length; j++) {
                if(input[j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                } else if(input[j].equals("L")) {
                    handle[0] = i;
                    handle[1] = j;
                } else if(input[j].equals("E")) {
                    end[0] = i;
                    end[1] = j;
                }
                map[i][j] = input[j];
            }
        }
        
        // 시작 -> 레버
        bfs(start, handle);
        if(answer == 0) return -1;
        int standard = answer;
        
        // 레버 -> 출구
        bfs(handle, end);
        
        if(answer == standard) return -1;
        return answer;
    }
    
    private void bfs(int[] start, int[] target) {
        visited = new boolean[map.length][map[0].length];
        visited[start[0]][start[1]] = true;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0});
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            if(temp[0] == target[0] && temp[1] == target[1]) {
                answer += temp[2];
                return;
            }
            
            for(int i=0; i<4; i++) {
                int tempX = temp[0] + dx[i];
                int tempY = temp[1] + dy[i];
                
                if(isValid(tempX, tempY) && !visited[tempX][tempY] && !map[tempX][tempY].equals("X")) {
                    visited[tempX][tempY] = true;
                    q.add(new int[]{tempX, tempY, temp[2]+1});
                }
            }
        }
    }
    
    private boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<map.length && y<map[0].length;
    }
}