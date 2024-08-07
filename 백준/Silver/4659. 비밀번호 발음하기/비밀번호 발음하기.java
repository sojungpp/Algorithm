import java.util.*;
import java.lang.*;
import java.io.*;
/*
모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
*/
class Main {
    
    static char[] cons = {'a', 'e', 'i', 'o', 'u'};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String word = sc.next();
            char[] words = word.toCharArray();
            boolean hasCons = false;
            boolean isValid = true;
            
            int conNum = 0;
            int vowelNum = 0;
            if(word.equals("end")) break;
            for(int i=0; i<word.length(); i++){
                if(isCons(word.charAt(i))) {
                    hasCons = true;
                    conNum++;
                    vowelNum = 0;
                }
                else {
                    vowelNum++;
                    conNum = 0;
                }
                
                if(conNum == 3 || vowelNum == 3){
                    isValid = false;
                    break;
                }
                if(i != word.length()-1 && word.charAt(i) == word.charAt(i+1)){
                    if(word.charAt(i) != 'e' && word.charAt(i) != 'o') {
                        isValid = false;
                        break;
                    }
                }
            }
            if(!hasCons) isValid = false;

            if(!isValid) System.out.println("<" + word + "> is not acceptable.");
            else System.out.println("<" + word + "> is acceptable.");
        }
        
    }

    private static boolean isCons(char target) {
        for(char c : cons){
            if(target == c) return true;
        }
        return false;
    }
}