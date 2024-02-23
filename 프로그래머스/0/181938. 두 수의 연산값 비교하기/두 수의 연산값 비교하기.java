import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int mutiplyValue = 2*a*b;
        String stringValue = Integer.toString(a) + Integer.toString(b);
        int value = Integer.parseInt(stringValue);
        
        return Math.max(value, mutiplyValue);
    }
}