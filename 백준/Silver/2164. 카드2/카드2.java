import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Integer> deque = new LinkedList<>();
        for(int i=1; i<N+1; i++){
            deque.add(i);
        }

        while(deque.size() != 1){
            deque.removeFirst();
            deque.addLast(deque.pollFirst());
        }

        System.out.println(deque.pollLast());
        
    }
}