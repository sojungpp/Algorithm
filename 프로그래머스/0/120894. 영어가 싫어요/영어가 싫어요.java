class Solution {
    public long solution(String numbers) {
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        for(int i=0; i<number.length; i++){
            numbers = numbers.replace(number[i], String.valueOf(num[i]));
        }
        return Long.parseLong(numbers);
    }
}