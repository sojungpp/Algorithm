class Solution {
    public String solution(String rsp) {
        char[] rsps = rsp.toCharArray();
        String answer = "";
        for(int i=0; i<rsps.length; i++){
            switch(rsps[i]){
                case '2': answer += "0"; break;
                case '0': answer += "5"; break;
                case '5': answer += "2"; break;
            }
        }
        return answer;
    }
}