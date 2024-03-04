class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] values = s.split(" ");
        int temp = 0;
        for(String value : values){
            if(value.equals("Z")) answer -= temp;
            else {
                temp = Integer.parseInt(value);
                answer += temp;
            }
        }
        return answer;
    }
}