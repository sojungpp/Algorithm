import java.util.*;

class Solution {
    int target, answer;
    int[] numbers;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);
        
        return answer;
    }
    
    private void dfs(int index, int value) {
        if(index == numbers.length) {
            if(value == target) answer++;
            return;
        }
        
        for(int i=0; i<2; i++) {
            if(i==0) {
                dfs(index+1, value + numbers[index]);
            } else {
                dfs(index+1, value - numbers[index]);
            }
        }
    }
}