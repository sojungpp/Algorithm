class Solution {
    public int solution(int n) {
                
        int answer = 0;
        char[] nums = String.valueOf(n).toCharArray();
        
        for(char num : nums){
            answer += (int) num - '0';
        }
        
        return answer;
    }
}