class Solution {
    
    public long solution(int n) {
        long[] result = new long[n+2];
        result[0] = 0;
        result[1] = 1;
        for(int i=2; i<=n+1; i++){
            result[i] = (result[i-1] + result[i-2])%1234567;
        }
        return result[n+1];
    }
}