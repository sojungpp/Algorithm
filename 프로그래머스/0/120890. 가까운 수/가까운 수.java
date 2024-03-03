class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int difference = Integer.MAX_VALUE;
        for(int a : array){
            if(difference > Math.abs(n-a)) {
                answer = a;
                difference = Math.abs(n-a);
            }
            else if(difference == Math.abs(n-a)) answer = Math.min(a, answer);
        }
        return answer;
    }
}