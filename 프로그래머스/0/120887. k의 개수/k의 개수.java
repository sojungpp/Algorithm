class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int a=i; a<=j; a++){
            String temp = String.valueOf(a);
            while(temp.contains(String.valueOf(k))){
                answer++;
                temp = temp.replaceFirst(String.valueOf(k), "");
            }
        }
        return answer;
    }
}