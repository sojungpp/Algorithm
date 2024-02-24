class Solution {
    public int solution(String[] spell, String[] dic) {
        
        for(String d : dic){
            String temp = d;
            for(String s : spell){
                if(temp.contains(s)) temp = temp.replaceFirst(s, "");
            }
        if(d.length() - spell.length == temp.length()) return 1;
        }
        return 2;
    }
}