class Solution {
    public int solution(int n, int k) {
        int freeDrink = n/10;
        return n*12000 + (k-freeDrink)*2000;
    }
}