import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        if(k%2 != 0){
            for(int num : arr) answer.add(num*k);
        } else {
            for(int num : arr) answer.add(num+k);
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}