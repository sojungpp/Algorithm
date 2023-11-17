import java.util.*;

class Solution {
    int N;
    int number;
    int answer = 9;
    
    void dfs(int size, int now) {
        if (size>8) return;
        if (number == now){
            answer = Math.min(size, answer);
            return;
        }
        
        int temp = 0;
        
        for (int i=0; i<8; i++) {
            if (size+i<8) {
                temp = temp*10+N;
                dfs(size+i+1, now+temp);
                dfs(size+i+1, now-temp);
                dfs(size+i+1, now*temp);
                dfs(size+i+1, now/temp);
            }
        }
    }
    
    public int solution(int N, int number) {
        this.N = N;
        this.number = number;
        
        dfs(0, 0);
        if (answer == 9) return -1;
        return answer;
        
    }
}