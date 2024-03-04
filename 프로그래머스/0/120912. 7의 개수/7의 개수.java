class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int a : array){
            String value = String.valueOf(a);
            while(value.contains("7")){
                answer++;
                value = value.replaceFirst("7", "");
            }
        }
        return answer;
    }
}