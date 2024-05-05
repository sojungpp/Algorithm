import java.util.*;

class Solution{
    public int solution(String s){
        String[] spells = s.split("");
        Stack<String> stack = new Stack<>();
        
        for(String spell : spells){
            // 스택 비어있지 않으면, 상위랑 비교해서 pop
            if(!stack.isEmpty()){
                if(spell.equals(stack.peek())) stack.pop();
                else stack.push(spell);
            } else stack.push(spell);
        }
        
        if(stack.isEmpty()) return 1;
        else return 0;
    }
}