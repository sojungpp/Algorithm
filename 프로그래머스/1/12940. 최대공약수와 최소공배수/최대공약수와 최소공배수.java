import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int a = n;
        int b = m;
        if(b >= a) {
            a = m;
            b = n;
        }
        
        int multiplication = a*b;
        int temp = 0;
        
        while(b!=0) {
            temp = a%b;
            a = b;
            b = temp;
        }
        
        answer[0] = a;
        answer[1] = multiplication / a;
        
        return answer;
    }
}