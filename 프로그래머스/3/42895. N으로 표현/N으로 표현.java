import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        
        if(N == number) return 1;
        
        for(int i=0; i<=8; i++) {
            list.add(new HashSet<>());
        }
        
        list.get(1).add(N);
        
        for(int i=2; i<=8; i++) {
            Set<Integer> nowSet = list.get(i);
            String num = String.valueOf(N).repeat(i);
            nowSet.add(Integer.parseInt(num));
            
            for(int j=1; j<i; j++) {
                for(int temp1 : list.get(j)) {
                    for(int temp2 : list.get(i-j)) {
                        nowSet.add(temp1 + temp2);
                        nowSet.add(temp1 - temp2);
                        nowSet.add(temp1 * temp2);
                        if(temp2 != 0) nowSet.add(temp1 / temp2);
                    }
                }
            }
            
            if(list.get(i).contains(number)) return i;

        }
        
        return -1;
    }
}