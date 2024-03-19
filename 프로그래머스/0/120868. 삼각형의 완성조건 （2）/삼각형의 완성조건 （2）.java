class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int maxLine = sides[0];
        int line = sides[1];
        if(sides[0]<sides[1]) {
            maxLine = sides[1];
            line = sides[0];
        }
        answer += line;
        answer += line-1;
        return answer;
    }
}