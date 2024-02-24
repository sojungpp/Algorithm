import java.util.*;

class Solution {
    
    private boolean isPrime(int n){
        for(int i=2; i<n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    
    public int[] solution(int n) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=2; i<n+1; i++){
            if(n%i == 0 && isPrime(i)) list.add(i);
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}