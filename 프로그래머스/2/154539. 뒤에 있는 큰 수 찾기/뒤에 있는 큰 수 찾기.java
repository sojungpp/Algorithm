import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        answer[numbers.length-1] = -1;
        stack.push(numbers[numbers.length-1]);
        for(int i=numbers.length-2; i>=0; i--) {
            int temp = -1;
            while(!stack.isEmpty()) {
                if(numbers[i] < stack.peek()) {
                    temp = stack.peek();
                    break;
                } else stack.pop();
            }
            stack.push(numbers[i]);
            answer[i] = temp;
        }
        
        return answer;
    }
}