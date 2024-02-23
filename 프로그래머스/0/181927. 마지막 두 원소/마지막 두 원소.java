import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<num_list.length; i++){
            answer.add(num_list[i]);
        }
        int lastNum = num_list[num_list.length-1];
        int previousNum = num_list[num_list.length-2];
        if(lastNum > previousNum) answer.add(lastNum - previousNum);
        else answer.add(lastNum * 2);

        return answer.stream().mapToInt(i->i).toArray();
    }
}