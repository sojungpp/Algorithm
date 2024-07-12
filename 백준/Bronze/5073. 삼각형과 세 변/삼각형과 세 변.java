import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            Set<Integer> lines = new HashSet<>();
            int line1 = sc.nextInt();
            if(line1 == 0) break;
            lines.add(line1);    
            int line2 = sc.nextInt();
            lines.add(line2);    
            int line3 = sc.nextInt();
            lines.add(line3);    
            int max = Math.max(line1, Math.max(line2, line3));
            if(max >= line1 + line2 + line3 - max){
                System.out.println("Invalid");
                continue;
            }
            if(lines.size() == 1) System.out.println("Equilateral");
            else if(lines.size() == 2) System.out.println("Isosceles");
            else if(lines.size() == 3) System.out.println("Scalene");
        } 
    }
}