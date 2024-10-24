import java.util.*;

class Solution {
    boolean[] visited;
    String begin, target;
    String[] words;
    int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        this.begin = begin;
        this.target = target;
        this.words = words;
        
        List<String> wordList = new ArrayList<>();
        for(String word : words) {
            wordList.add(word);
        }
        if(!wordList.contains(target)) return 0;
        
        for(int i=0; i<words.length; i++){
            visited = new boolean[words.length];
            if(canChange(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], 1);
            }
        }
        
        return answer;
    }
    
    private void dfs(String now, int cnt) {
        if(now.equals(target)){
            answer = Math.min(cnt, answer);
        }
        
        for(int i=0; i<words.length; i++) {
            if(!visited[i] && canChange(now, words[i])) {
                visited[i] = true;
                dfs(words[i], cnt+1);
                visited[i] = false;
            }
        }
    }
    
    private boolean canChange(String begin, String target) {
        boolean isValid = false;
        for(int i=0; i<begin.length(); i++) {
            if(begin.charAt(i) == target.charAt(i)) continue;
            else {
                if(isValid) return false;
                else isValid = true;
            }
        }
        return true;
    }
}