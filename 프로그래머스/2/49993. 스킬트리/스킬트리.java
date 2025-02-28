import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        char[] skillArray = skill.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char s : skillArray) {
            set.add(s);
        }
        
        int answer = 0;
        for(String skill_tree : skill_trees) {
            boolean isPossible = true;
            int index = 0;
            for(int i=0; i<skill_tree.length(); i++) {
                char target = skill_tree.charAt(i);
                if(set.contains(target)) {
                    if(target == skill.charAt(index)) {
                        index++;
                        continue;
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }
            if(isPossible) answer++;
        }
        
        return answer;
    }
}