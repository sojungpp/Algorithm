import java.util.*;

class Solution {
    static int[][] islands;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int temp;
    static String[] maps;
    
    private void check(int x, int y){
        visited[x][y] = true;
        if(islands[x][y] == 0) return;
        temp += islands[x][y];
        
        for(int i=0; i<4; i++){
            int nowX = x + dx[i];
            int nowY = y + dy[i];
            if(isValid(nowX, nowY)) check(nowX, nowY);
        }
    }
    
    private boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<maps.length && y<maps[0].length() && !visited[x][y];
    }
    
    public int[] solution(String[] maps) {
        // 입력
        ArrayList<Integer> answer = new ArrayList<>();
        this.maps = maps;
        islands = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++){
            String[] str = maps[i].split("");
            for(int j=0; j<maps[0].length(); j++){
                if(str[j].equals("X")) islands[i][j] = 0;
                else islands[i][j] = Integer.parseInt(str[j]);
            }
        }
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                temp = 0;
                if(!visited[i][j]) check(i, j);
                if(temp != 0) answer.add(temp);
                
            }
        }
        
        if(answer.isEmpty()) return new int[]{-1};
        Collections.sort(answer);
        return answer.stream().mapToInt(i->i).toArray();
    }
}