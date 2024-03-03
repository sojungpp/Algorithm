import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        char[] array = my_string.toCharArray();
        List<Integer> answer = new ArrayList<>();
        for(char value : array){
            if(value >= '0' && value <= '9') answer.add((int)value - '0');
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(i->i).toArray();
    }
}