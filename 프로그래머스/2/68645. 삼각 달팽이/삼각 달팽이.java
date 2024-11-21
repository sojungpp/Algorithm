import java.util.*;

class Solution {
    
    int[][] array;
    int n;
    
    public int[] solution(int n) {
        
        array = new int[n][n];
        this.n = n;
        
        int nowX = 0;
        int nowY = 0;
        int num = 1;
        array[nowX][nowY] = num;
        num++;
        while(isVisitedAround(nowX, nowY)) {

            // 아래
            int temp = nowX;
            for(int i=nowX+1; i<n; i++) {
                if(array[i][nowY] != 0) {
                    nowX = i-1;
                    break;
                }
                array[i][nowY] = num;
                num++;
            }
            if(nowX == temp) nowX = n-1;
            
            // 우측
            temp = nowY;
            for(int i=nowY+1; i<=nowX; i++) {
                if(array[nowX][i] != 0) {
                    nowY = i-1;
                    break;
                }
                array[nowX][i] = num;
                num++;
            }
            if(nowY == temp) nowY = nowX;
            
            // 대각선왼쪽
            while(true) {
                int tempX = nowX-1;
                int tempY = nowY-1;
                if(tempX <= 0 || tempY <= 0 || array[tempX][tempY] != 0) break;
                
                array[tempX][tempY] = num;
                num++;
                nowX = tempX;
                nowY = tempY;
            }
        }
        
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                list.add(array[i][j]);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
    
    private boolean isVisitedAround(int x, int y) {
        if(x+1<n && array[x+1][y] == 0) return true;
        else return false;
    }
    
}