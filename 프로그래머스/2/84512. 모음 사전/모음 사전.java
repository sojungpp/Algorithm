import java.util.*;

class Solution {
    
    static String[] vowels = {"A", "E", "I", "O", "U"};
    
    private void dfs(List<String> list, String word){
        if(word.length() > 5) return;
        if(!list.contains(word)) list.add(word);
        for(int i=0; i<vowels.length; i++){
            dfs(list, word+vowels[i]);
        }
    }
    
    public int solution(String word) {
        List<String> list = new ArrayList<>();
        for(int i=0; i<vowels.length; i++){
            dfs(list, vowels[i]);
        }
        
        Collections.sort(list);
        int answer = 1;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(word)) return answer;
            else answer++;
        }
        
        return answer;
    }
}