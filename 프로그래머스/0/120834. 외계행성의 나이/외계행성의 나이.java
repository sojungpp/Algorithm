class Solution {
    
    public static String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    
    public String solution(int age) {
        String answer = "";
        char[] target = String.valueOf(age).toCharArray();
        for(char t : target){
            answer += alphabet[(int)t-'0'];
        }
        return answer;
    }
}