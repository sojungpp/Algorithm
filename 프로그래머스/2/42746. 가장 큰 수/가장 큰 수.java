import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        List<Integer> list = new ArrayList<>();
        for(int n : numbers) {
            list.add(n);
        }
        
        list.sort((a, b) -> {
            String tempA = String.valueOf(a);
            String tempB = String.valueOf(b);
            
            for(int i=0; i<Math.min(tempA.length(), tempB.length()); i++) {
                if(tempA.charAt(i) != tempB.charAt(i)) return tempB.charAt(i) - tempA.charAt(i);
            }
            
            return Integer.parseInt(tempB+tempA) - Integer.parseInt(tempA+tempB);
            
        });
        
        String answer = "";
        for(int i=0; i<list.size(); i++) {
            answer += String.valueOf(list.get(i));
        }

        if (answer.charAt(0) == '0') return "0";
        return answer;
    }
}