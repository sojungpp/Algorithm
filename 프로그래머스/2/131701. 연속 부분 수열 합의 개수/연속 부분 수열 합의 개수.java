import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<>();
        
        // 길이
        for(int i=1; i<=elements.length; i++){
            // 경우의 수 구해서 set에 넣기
            for(int j=0; j<=elements.length; j++){
                int temp = 0;
                for(int k=j; k<j+i; k++){
                    temp += elements[k%elements.length];
                }
                answer.add(temp);
            }
        }
        return answer.size();
        
    }
}