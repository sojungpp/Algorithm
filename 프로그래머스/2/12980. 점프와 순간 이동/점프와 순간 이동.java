import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n != 0){
            if(n%2 == 0){
                // 짝수인 경우
                n /= 2;
                continue;
            }
            answer++;
            n--;
        }
        return answer;
    }
}