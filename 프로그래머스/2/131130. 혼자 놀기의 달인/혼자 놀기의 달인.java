import java.util.*;

class Solution {
    public int solution(int[] cards) {
        
        boolean[] isOpened = new boolean[cards.length];
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<cards.length; i++) {
            if(isOpened[i]) continue;
            int num = 1;
            int index = i;  
            int temp = cards[index];
            isOpened[i] = true;
            
            while(!isOpened[cards[index]-1]) { 
                isOpened[cards[index]-1] = true;
                index = cards[index]-1;
                num++;
            }
            list.add(num);
            set.add(num);
        }
        
        Collections.sort(list, Comparator.reverseOrder());
        if(list.size() == 1) return 0;
        return list.get(0) * list.get(1);
    }
}