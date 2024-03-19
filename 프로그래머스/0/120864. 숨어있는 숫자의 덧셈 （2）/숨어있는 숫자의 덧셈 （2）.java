class Solution {
    public int solution(String my_string) {
        String[] str = my_string.split("");
        int answer = 0;
        String temp = "";
        for(int i=0; i<str.length; i++){
            if((int)my_string.charAt(i)>=48 && (int)my_string.charAt(i)<=57) temp += str[i];
            else if(!temp.equals("")){
                answer += Integer.parseInt(temp);
                temp = "";
            }
        }
        if(!temp.equals("")) answer += Integer.parseInt(temp);
        return answer;
    }
}