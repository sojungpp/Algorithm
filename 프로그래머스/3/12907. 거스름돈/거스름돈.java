import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int[] answer = new int[n+1];
        Arrays.sort(money);
        
        answer[0] = 1;
        for(int i=0; i<money.length; i++) {
            for(int j=money[i]; j<=n; j++) {
                answer[j] += answer[j-money[i]] % 1000000007;
            }
        }
        
        return answer[n];
    }
}