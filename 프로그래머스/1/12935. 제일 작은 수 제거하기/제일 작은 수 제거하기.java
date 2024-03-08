import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int index = 0;
        for(int i=0; i<arr.length; i++){
            answer.add(arr[i]);
            if(arr[index] > arr[i]) index = i;
        }
        answer.remove(index);
        if(answer.size() == 0) answer.add(-1);
        return answer.stream().mapToInt(i->i).toArray();
    }
}