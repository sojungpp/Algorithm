class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] strings = my_string.toCharArray();
        char temp = strings[num1];
        strings[num1] = strings[num2];
        strings[num2] = temp;
        return String.valueOf(strings);
    }
}