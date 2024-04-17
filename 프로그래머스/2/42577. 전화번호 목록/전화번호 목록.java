import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length-1; i++){
            String phone1 = phone_book[i];
            String phone2 = phone_book[i+1];
            if(phone1.startsWith(phone2) || phone2.startsWith(phone1)) return false;
        }
        return true;
    }
}