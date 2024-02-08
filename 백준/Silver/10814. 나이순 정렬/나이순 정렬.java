import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        TreeMap<Integer, List<String>> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            int age = sc.nextInt();
            String name = sc.next();

            List<String> nameList = new ArrayList<>();
            if(map.containsKey(age)) nameList = map.get(age);
            nameList.add(name);
            map.put(age, nameList);
        }

        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            Integer age = entry.getKey();
            List<String> nameList = entry.getValue();
            for (String name : nameList) {
                System.out.println(age + " " + name);
            }
        }
    }
}
