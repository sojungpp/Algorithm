import java.util.*;

class Solution {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        char[] strings = my_string.toCharArray();
        Arrays.sort(strings);
        return String.valueOf(strings);
    }
}