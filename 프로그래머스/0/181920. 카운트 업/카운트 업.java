import java.util.*;

class Solution {
    public int[] solution(int start_num, int end_num) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int target = start_num;
        answer.add(target);
        while(target != end_num) {
            target++;
            answer.add(target);
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}