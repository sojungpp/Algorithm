class Solution {
    
    public static String[] morse = {
        ".-","-...","-.-.","-..",".","..-.",
        "--.","....","..",".---","-.-",".-..","--","-.",
        "---",".--.","--.-",".-.","...","-","..-","...-",
        ".--","-..-","-.--","--.."};
    
    public String solution(String letter) {
        String answer = "";
        String[] target = letter.split(" ");
        for(String t : target){
            for(int i=0; i<morse.length; i++){
                if(morse[i].equals(t)) {
                    answer += Character.toString('a'+i);
                }
            }
        }
        return answer;
    }
}