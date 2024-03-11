import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        List<String> answer = new ArrayList<>();
        
        while(my_str.length() >= n) {
            String temp = my_str.substring(0, n);
            answer.add(temp);
            my_str = my_str.substring(n);
        }
        if(my_str.length() != 0) answer.add(my_str);
        return answer.toArray(new String[0]);
    }
}