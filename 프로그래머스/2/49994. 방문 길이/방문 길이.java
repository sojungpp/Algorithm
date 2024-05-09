import java.util.*;

class Solution {
    
    static boolean[][][] maps = new boolean[11][11][4];
    
    private int[] move(String direction, int[] now){
        switch(direction){
            case "U": if(isValid(now[0], now[1]+1)) {now[1]+=1;
                if(!maps[now[0]][now[1]][0] && !maps[now[0]][now[1]-1][1]) maps[now[0]][now[1]][0] = true;
                                                    }
                break;
            case "D": if(isValid(now[0], now[1]-1)) {now[1]-=1;
                if(!maps[now[0]][now[1]][1] && !maps[now[0]][now[1]+1][0]) maps[now[0]][now[1]][1] = true;}
                break;
            case "L": if(isValid(now[0]+1, now[1])) {now[0]+=1; 
                if(!maps[now[0]][now[1]][2] && !maps[now[0]-1][now[1]][3]) maps[now[0]][now[1]][2] = true;}
                break;
            default: if(isValid(now[0]-1, now[1])) {now[0]-=1; 
                if(!maps[now[0]][now[1]][3] && !maps[now[0]+1][now[1]][2]) maps[now[0]][now[1]][3] = true;}
                break;
        }
        return now;
    }
    
    private boolean isValid(int x, int y){
        return (x <= 10 && y <= 10 && x >= 0 && y >= 0);
    }
    
    public int solution(String dirs) {
        String[] array = dirs.split("");
        int[] now = {5, 5};
        for(String direction : array){
            now = move(direction, now);
        }
        
        int answer = 0;
        for(int i=0; i<11; i++){
            for(int j=0; j<11; j++){
                for(int z=0; z<4; z++)
                if(maps[i][j][z]) answer++;
            }
        }
        
        return answer;
    }
}