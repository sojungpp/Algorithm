import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] inputs = s.toCharArray();
        Queue<Character> q = new LinkedList<>();
        for(char input : inputs) {
            q.add(input);
        }
        
        int left = 1;
        if(q.poll() == ')') return false;
        
        while(!q.isEmpty()) {
            char temp = q.poll();
            if(temp == ')') {
                if(left == 0) return false;
                left--;
            } else {
                left++;
            }
        }
        return left == 0;
    }
}