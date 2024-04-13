import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Integer> list = new ArrayList<>();
        for(int num : numlist){
            list.add(num);
        }
        Collections.sort(list, Comparator.reverseOrder());
        Collections.sort(list, (Integer a, Integer b) -> {
            return Math.abs(a - n) - Math.abs(b - n);
        });
        
        return list.stream().mapToInt(i->i).toArray();
    }
}