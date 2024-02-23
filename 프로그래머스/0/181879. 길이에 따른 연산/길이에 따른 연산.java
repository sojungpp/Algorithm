class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        if(num_list.length < 11) answer = 1;
            
        for(int num : num_list){
            if(num_list.length < 11) answer *= num;
            else answer += num;
        }
        
        return answer;
    }
}