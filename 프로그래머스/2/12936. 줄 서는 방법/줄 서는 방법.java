import java.util.*;

class Solution {
    // n = 사람, k = 몇 번째?
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long sum = 1;
        
        // 전체 경우의 수 (sum), 사람 초기화
        for(int i=1; i<=n; i++) {
            sum *= i;
            list.add(i);
        }
        // 인덱스 초기화 (0부터 시작)
        k--;
        int index = 0;
        
        while(n > 0) {
            // 자리에 들어갈 경우의 수
            sum /= n;
            // 자리 숫자
            int temp = (int) (k / sum);
            answer[index] = list.get(temp);
            list.remove(temp);
            
            // 다음 자릿수 위해 업데이트
            k %= sum;
            index++;
            n--;
        }
        
        return answer;
    }
}