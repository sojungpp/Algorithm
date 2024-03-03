import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        List<Integer> answer = new ArrayList<>();
        for(int num : numbers){
            answer.add(num);
        }
        switch(direction){
            case "left":
                answer.add(numbers[0]);
                answer.remove(0);
                break;
            case "right":
                answer.add(0, numbers[numbers.length-1]);
                answer.remove(answer.size()-1);
                break;
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}