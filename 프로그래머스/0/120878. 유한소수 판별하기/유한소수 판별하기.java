class Solution {
    
    private int gcd(int a, int b){
        if(a%b == 0){
            return b;
        }
        return gcd(b, a%b);
    }
    
    public int solution(int a, int b) {
        int gcd = gcd(a, b);
        int temp = b/gcd;
        while(temp!=1){
            if(temp%2==0) temp /= 2;
            else if(temp%5==0) temp /= 5;
            else if(temp%10==0) temp /= 10;
            else return 2;
        }
        return 1;
    }
}