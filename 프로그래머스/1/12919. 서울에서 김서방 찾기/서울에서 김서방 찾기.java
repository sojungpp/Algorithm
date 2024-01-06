import java.util.*;

class Solution {
    
    private static final String TARGET = "Kim";
    
    public String solution(String[] seoul) {
        int index = Arrays.asList(seoul).indexOf(TARGET);
        return "김서방은 " + index + "에 있다";
    }
}