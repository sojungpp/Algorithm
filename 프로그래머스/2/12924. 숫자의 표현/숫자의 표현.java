class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=10000; i++){
            int sum = i;
            if(sum > n) break;
            for(int j=i+1; j<=10000; j++){
                sum += j;
                if(sum > n) break;
                if(sum == n) answer++;
            }
        }
        return answer+1;
    }
}