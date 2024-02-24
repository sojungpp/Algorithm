class Solution {
    public int solution(int[] num_list) {
        
        String odd = "";
        String even = "";
        
        for(int num : num_list){
            if(num%2 == 0) even += String.valueOf(num);
            else odd += String.valueOf(num);
        }
        
        return Integer.parseInt(odd) + Integer.parseInt(even);
    }
}