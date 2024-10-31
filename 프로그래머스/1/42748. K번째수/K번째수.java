import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=commands[i][0]-1; j<=commands[i][1]-1; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);
            
            int index = 0;
            for(Integer value : list) {
                if(index == commands[i][2]-1) {
                    answer[i] = value;
                    break;
                }
                index++;
            }
        }

        return answer;
    }
}