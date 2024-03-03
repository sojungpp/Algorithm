class Solution {
    public int solution(int order) {
        String temp = String.valueOf(order);
        temp = temp.replaceAll("3", "");
        temp = temp.replaceAll("6", "");
        temp = temp.replaceAll("9", "");
        return String.valueOf(order).length() - temp.length();
    }
}