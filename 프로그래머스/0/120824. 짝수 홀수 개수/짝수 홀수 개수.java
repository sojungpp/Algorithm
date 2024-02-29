class Solution {
    public int[] solution(int[] num_list) {
        int odd = 0;
        int even = 0;
        
        for(int num : num_list){
            if(num%2 == 0) even++;
            else odd ++;
        }
        
        int[] answer = new int[]{even, odd};
        return answer;
    }
}