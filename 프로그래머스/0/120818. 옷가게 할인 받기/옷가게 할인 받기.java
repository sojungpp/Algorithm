class Solution {
    public int solution(int price) {
        int salePercent = 0;
        if(price >= 500000) salePercent = 20;
        else if(price >= 300000) salePercent = 10;
        else if(price >= 100000) salePercent = 5;
        
        return price*(100-salePercent)/100;
    }
}