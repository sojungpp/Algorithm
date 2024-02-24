class Solution {
    public int solution(String before, String after) {
        char[] targets = before.toCharArray();
        for(char target : targets){
            if(after.contains(String.valueOf(target))) after = after.replaceFirst(Character.toString(target), "");
            else return 0;
        }
        return 1;
    }
}