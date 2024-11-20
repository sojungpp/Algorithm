import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {

        
        int standardX = (int) (left%n);
        int standardY = (int) (left/n);
        
        long standard = right - left;
        int[] answer = new int[(int)standard+1];
        int num = 0;
        
        while(num != standard+1) {
            if(standardY <= standardX) answer[num] = standardX+1;
            else answer[num] = standardY+1;
            
            standardY = (standardX+1 >= n) ? standardY+1 : standardY;
            standardX = (standardX+1)%n;
            num++;
        }

        
        return answer;
    }
}