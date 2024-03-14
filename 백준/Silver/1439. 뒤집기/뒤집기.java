import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        char[] str = string.toCharArray();
        char target = str[0];
        int answer = 1;

        for(int i=0; i<str.length; i++){
            if(str[i] != target){
                answer++;
                target = str[i];
            }
        }
        
        System.out.println(answer/2);  
    }
}