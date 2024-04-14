class Solution {
    
    public String[] words = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String b : babbling){
            for(int i=0; i<words.length; i++){
                if(b.contains(words[i])) b = b.replace(words[i], "0");
            }
            if(b.replace("0","").equals("")) answer++;
        }
        
        return answer;
    }
}