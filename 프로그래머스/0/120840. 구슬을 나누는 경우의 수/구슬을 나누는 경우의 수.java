class Solution {
    
    private int select(int a, int b){
        if(a==b || b==0) return 1;
        return select(a-1, b) + select(a-1, b-1);
    }
    
    public int solution(int balls, int share) {
        return select(balls, share);
    }
}