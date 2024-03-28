class Solution {
    public int[] solution(int num, int total) {
        
        int[] answer = new int[num];
        
        // 홀수일 때
        if(num%2 != 0){
            int middle = total/num;
            answer[num/2] = middle;
            for(int i=0; i<num/2; i++){
                answer[i] = middle - num/2 + i;
                answer[answer.length-i-1] = middle + num/2 - i;
            }
        }
        // 짝수일 때
        else{
            int temp = total / (num / 2);
            int first = temp / 2 - (num/2-1);
            for(int i=0; i<answer.length; i++){
                answer[i] = first;
                first++;
            }
        }
        return answer;
    }
}