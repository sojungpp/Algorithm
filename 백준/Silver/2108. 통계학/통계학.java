import java.util.*;


public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> keys = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            sum += num;
            keys.add(num);
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }

        // 산술평균
        System.out.println(String.format("%.0f", (double) sum / N).equals("-0") ? 0 : String.format("%.0f", (double) sum / N));

        // 중앙값
        Collections.sort(keys);
        System.out.println(keys.get(N / 2));

        // 최빈값
        List<Integer> maxKeys = new ArrayList<>();
        int maxValue = Collections.max(map.values());
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == maxValue) {
                maxKeys.add(e.getKey());
            }
        }
        Collections.sort(maxKeys);
        System.out.println(N == 1 || maxKeys.size() == 1 ? maxKeys.get(0) : maxKeys.get(1));

        // 범위
        System.out.println(map.lastKey() - map.firstKey());
    }
}
