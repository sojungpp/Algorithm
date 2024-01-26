class Solution {
    
    public int solution(int[] numbers) {
        int answer = 0;
        boolean existNums[] = new boolean[10];
        
        for(int num: numbers){
            existNums[num] = true;
        }
        
        for(int i=0; i<existNums.length; i++){
            if(!existNums[i]) answer += i;
        }

        return answer;
    }
}