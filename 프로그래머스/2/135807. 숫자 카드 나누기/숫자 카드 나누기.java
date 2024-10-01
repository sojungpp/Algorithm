import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int standard = 0;
        int answer = 0;
        
        for(int i=arrayA[0]; i>1; i--) {
            if(arrayA[0] % i == 0) standard = i;
            else continue;
            
            if(!isDivided(arrayA, standard)) continue;
            else if(isNotDivided(arrayB, standard)) {
                answer = standard;
                break;
            }
        }
        
        for(int i=arrayB[0]; i>1; i--) {
            if(arrayB[0] % i == 0) standard = i;
            else continue;
            
            if(!isDivided(arrayB, standard)) continue;
            else if(isNotDivided(arrayA, standard)) return Math.max(standard, answer);
        }

        return answer;
    }
    
    // standard로 하나라도 안 나눠지면 false
    private boolean isDivided(int[] array, int standard) {
        for(int i=0; i<array.length; i++) {
            if(array[i] % standard != 0) {
                return false;
            }
        }
        return true;
    }
    
    // standard로 하나라도 나눠지면 false
    private boolean isNotDivided(int[] array, int standard) {
        for(int i=0; i<array.length; i++) {
            if(array[i] % standard == 0) {
                return false;
            }
        }
        return true;
    }
}