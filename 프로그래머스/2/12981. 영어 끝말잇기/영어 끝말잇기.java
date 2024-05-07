import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};
        int round = 0;
        Set<String> set = new HashSet<>();
        String standard = "";

        for(int i=0; i<words.length; i++){
            if(i%n == 0) answer[1]++;
            if(i==0){
                standard = words[i];
                set.add(words[i]);
                continue;
            }
            if(set.contains(words[i]) || standard.charAt(standard.length()-1) != words[i].charAt(0)){
                System.out.println(i);
                // 순서의 사람 = i%n + 1
                answer[0] = i%n + 1;
                break;
            }
            set.add(words[i]);
            standard = words[i];
            
            if(i == words.length-1) return new int[]{0, 0};
        }
        
        return answer;
        
        
    }
}