import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    String numbers;
    
    public int solution(String numbers) {
        
        this.visited = new boolean[numbers.length()];
        this.numbers = numbers;
        for(int i=1; i<=numbers.length(); i++) {
            dfs(i, "");
        }
        
        int answer = 0;
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
            if(isPrime(iter.next())) answer++;
        }
        
        return answer;
    }
    
    private void dfs(int depth, String temp) {
        if(depth == temp.length()) {
            set.add(Integer.parseInt(temp));
            return;
        }
        
        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth, temp + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int target) {
        if(target<2) return false;
        for(int i=2; i<=Math.sqrt(target); i++) {
            if(target%i == 0) return false;
        }
        return true;
    }
}