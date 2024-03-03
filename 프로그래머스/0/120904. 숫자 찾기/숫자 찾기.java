class Solution {
    public int solution(int num, int k) {
        String number = String.valueOf(num);
        if(number.contains(String.valueOf(k))) return number.indexOf(String.valueOf(k))+1;
        else return -1;
    }
}