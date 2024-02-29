class Solution {
    public int solution(int[] sides) {
        int max = 0;
        int sum = 0;
        for(int side : sides){
            if(side > max) {
                sum += max;
                max = side;
            } else sum+= side;
        }
        if(max < sum) return 1;
        else return 2;
    }
}