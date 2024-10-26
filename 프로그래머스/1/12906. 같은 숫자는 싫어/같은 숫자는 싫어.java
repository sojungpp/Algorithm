import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        Queue<Integer> q = new LinkedList<>();
        for(int a : arr) {
            q.add(a);
        }
        
        List<Integer> list = new ArrayList<>();
        int value = q.poll();
        list.add(value);
        while(!q.isEmpty()) {
            int temp = q.poll();
            if(temp == value) continue;
            else {
                value = temp;
                list.add(value);
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}