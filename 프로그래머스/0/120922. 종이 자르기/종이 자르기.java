class Solution {
    public int solution(int M, int N) {
        int answer = 0;
        answer += M - 1;
        answer += (N - 1)*M;
        return answer;
    }
}