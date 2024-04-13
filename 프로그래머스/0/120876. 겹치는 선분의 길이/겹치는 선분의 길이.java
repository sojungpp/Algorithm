class Solution {
    public int solution(int[][] lines) {
        
        int[] arr = new int[200];
        
        for(int[] l : lines){
            for(int i=l[0]+100; i<l[1]+100; i++){
                arr[i]++;
            }
        }
        
        int answer = 0;
        for(int a : arr){
            if(a>1) answer++;
        }
        
        return answer;
    }
}