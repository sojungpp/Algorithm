class Solution {
    public String solution(String my_string) {
        String[] targets = new String[]{"a", "e", "i", "o", "u"};
        for(String target : targets){
            my_string = my_string.replace(target, "");
        }
        return my_string;
    }
}