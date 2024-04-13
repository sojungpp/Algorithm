class Solution {
    
    private int gcd(int a, int b){
        if(a%b == 0){
            return b;
        }
        return gcd(b, a%b);
    }
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int answerNumer = numer1 * denom2 + denom1 * numer2;
        int answerDenom = denom1 * denom2;
        
        int gcd = gcd(answerNumer, answerDenom);
        
        
        int[] answer = {answerNumer/gcd, answerDenom/gcd};
        return answer;
    }
}