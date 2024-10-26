import java.util.*;

class Solution {
    int[] numbers;
    int target;
    int answer;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);

        return answer;
    }
    
    private void dfs(int index, int sum) {
        if(index == numbers.length) {
            if(sum == target) answer++;
            return;
        }

        for(int i=0; i<2; i++) {
            if(i==0) dfs(index+1, sum+numbers[index]);
            else dfs(index+1, sum-numbers[index]);
        }
    }
}