import java.util.*;

class Solution {
    List<Integer> list = new ArrayList<>();
    boolean[] visited;
    int[] nums;
    int answer = 0;
    
    public int solution(int[] nums) {
        this.nums = nums;
        this.visited = new boolean[nums.length];
        
        dfs(0, 0, 0);
     
        return answer;
    }
    
    private void dfs(int idx, int sum, int cnt) {
        if(cnt == 3) {
            if(isPrime(sum)) answer++;
            return;
        }
        
        for(int i=idx; i<nums.length; i++) {
            dfs(i+1, sum+nums[i], cnt+1);
        }
    }
    
    private boolean isPrime(int num) {
        if(num < 2) return false;
        
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
}