class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int p = s.length() - s.replaceAll("p", "").length();
        int y = s.length() - s.replaceAll("y", "").length();

        if(p != y) return false;
        if(p == 0 && y==0) return true;
        return true;
    }
}