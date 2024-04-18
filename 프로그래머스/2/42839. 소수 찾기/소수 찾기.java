import java.util.*;

class Solution {
    
    static Set<Integer> list = new HashSet<>();
    static boolean[] visited = new boolean[7];
    
    private void permutation(String str, String temp, int length) {
        
        if(temp.length() == length) {
            int num = Integer.parseInt(temp);
            list.add(num);
        }

        for(int i=0; i<str.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp += str.charAt(i);
                permutation(str, temp, length);
                visited[i] = false;
                temp = temp.substring(0, temp.length()-1);
            }
        }
    }
    
    private boolean isPrime(int num){
        if(num<2) return false;
        for(int i=2; i<=(int) Math.sqrt(num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
    
    public int solution(String numbers) {
        // 가능한 조합
        for(int i=1; i<=numbers.length(); i++) {
            permutation(numbers, "", i);
        }
        
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            Integer num = iter.next();
            // 소수 여부
            if (!isPrime(num)) {
                iter.remove();
            }
        }
        return list.size();
    }
}