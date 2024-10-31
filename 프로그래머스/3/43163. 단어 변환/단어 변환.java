import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    String[] words;
    String target;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        Arrays.sort(words);
        
        for(int i=0; i<words.length; i++) {
            this.visited = new boolean[words.length];
            if(!visited[i] && isValid(begin, words[i])) {
                visited[i] = true;
                search(words[i], 1);
            }
        }
        
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    private void search(String word, int cnt) {
        if(word.equals(target)) {
            answer = Math.min(cnt, answer);
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            if(!visited[i] && isValid(word, words[i])) {
                visited[i] = true;
                search(words[i], cnt+1);
                visited[i] = false;
            }
        }
    }
    
    private boolean isValid(String begin, String target) {
        boolean isValid = false;
        for(int i=0; i<begin.length(); i++) {
            if(begin.charAt(i) == target.charAt(i)) continue;
            else if(!isValid) isValid = true;
            else return false;
        }
        return true;
    }
}