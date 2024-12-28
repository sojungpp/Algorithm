import java.util.*;

// 번호, 차례
class Solution {
    public int[] solution(int n, String[] words) {
        
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        
        for(int i=1; i<words.length; i++) {
            String word = words[i];
            // 한 글자 유무
            if(word.length() == 1) {
                return new int[]{i%n+1, i/n+1};
            }
            
            // 옳은 끝말잇기 단어 유무            
            if(words[i-1].charAt(words[i-1].length()-1) != word.charAt(0)) {
                return new int[]{i%n+1, i/n+1};
            }
            
            // 등장했던 단어 유무
            if(set.contains(word)) {
                return new int[]{i%n+1, i/n+1};
            }
            
            set.add(word);
            
        }    
        return new int[]{0, 0};
    }
}