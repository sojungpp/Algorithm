import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Stack<Integer> s = new Stack<Integer>();
        for(int i=numbers.length-1; i>=0; i--){
            
            while(!s.isEmpty() && numbers[i] >= s.peek()){
                s.pop();
            }
            
            if(!s.isEmpty()){
                answer[i] = s.peek();
            }
            
            s.add(numbers[i]);
            
        }
        
        return answer;
        
    }
}