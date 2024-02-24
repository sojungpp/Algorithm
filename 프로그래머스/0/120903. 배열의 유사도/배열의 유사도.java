import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        for(String s : s1) list.add(s);
        
        for(String s : s2){
            if(list.contains(s)) answer += 1;
        }
        
        return answer;
    }
}