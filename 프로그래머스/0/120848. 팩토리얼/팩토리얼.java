class Solution {
    
    private int factorial(int n){
        int temp = 1;
        for(int i=1; i<=n; i++){
            temp *= i;
        }
        return temp;
    }
    
    public int solution(int n) {
        
        int answer = 0;
        int index = 1;
        
        while(factorial(index) <= n){
            index++;
        }    
        return index-1;
    }
}