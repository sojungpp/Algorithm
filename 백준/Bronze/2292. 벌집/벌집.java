import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int start = 1;
        int end = 1;
        int index = 1;

        while(true){
            if(N >= start && N <= end){
                System.out.println(index);
                break;
            }
            start += 1;
            end += 6*index; 
            index++;
        }
    }
}