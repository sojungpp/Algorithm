import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] temp = emergency.clone();
        Arrays.sort(temp);
        
        for(int i=0; i<emergency.length; i++){
            for(int j=0; j<temp.length; j++){
                if(emergency[i] == temp[j]) {
                    emergency[i] = emergency.length - j;
                    break;
                }
            }
        }
        return emergency;
    }
}