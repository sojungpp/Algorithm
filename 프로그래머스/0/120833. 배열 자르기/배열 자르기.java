import java.util.*;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : numbers) list.add(num);
        return list.subList(num1, num2+1).stream().mapToInt(i->i).toArray();
    }
}