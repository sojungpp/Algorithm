import java.util.*;

class Solution {
    
    static int answer;
    
    private void check(String s){
        Stack<String> stack = new Stack<>();
        String[] brackets = s.split("");
        
        for(String b : brackets){
            if(!stack.isEmpty()){
                switch(stack.peek()){
                case "(": 
                    if(b.equals(")")) stack.pop();
                    else stack.push(b); break; 
                case "[": 
                    if(b.equals("]")) stack.pop();
                    else stack.push(b); break; 
                case "{": 
                    if(b.equals("}")) stack.pop();
                    else stack.push(b); break; 
                default: stack.push(b); break;
                }
            } else stack.push(b);
        }
        
        if(stack.isEmpty()) answer++;
    }
    
    public int solution(String s) {
        for(int i=0; i<s.length(); i++){
            check(s);
            String first = s.substring(0, 1);
            s = s.substring(1, s.length());
            s = s + first;
        }
        
        return answer;
    }
}