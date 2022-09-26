package interview;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.function.Function;

public class Solution0925 {

    static String[] examples = {
            "ADFADA",
            "ADFADE",
            "ADBADE",
            "BDFJDFAADE",
            "FEAAQICMAA",
            "DFJOADJFOIAD",
    };

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            System.out.println(getRes(sc.nextLine()));
//        }
        func(Solution0925::getRes);
        func(Solution0925::getRes2);
        func(Solution0925::getRes3);
        func(Solution0925::getRes4);
        func(Solution0925::getRes5);

//        for (String example : examples) {
//            System.out.println(getRes(example));
//        }

    }

    private static void func(Function<String, String> function) {
        long startTime = System.currentTimeMillis();
        long repeatTime = 10000000L;
        for (long i = 0; i < repeatTime; i++) {
            for (String example : examples) {
                function.apply(example);
            }
        }
        System.out.println("花费时间：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public static String getRes(String dna) {
        if (dna == null || dna.length() == 0) return dna;
        char[] chars = (dna + dna).toCharArray();
        // 偏移
        int offset = 0, current = 1;
        while (current < dna.length()) {
            // 第一步，对比首位字母相同时的情况，应该取哪一个
            if (chars[current] == chars[offset]) {
                // 可优化
                boolean lower = new String(chars, offset, dna.length()).compareTo(new String(chars, current, dna.length())) < 0;
                if (!lower) {
                    offset = current;
                }
            } else if (chars[current] < chars[offset]) { // 首位字母比offset的还小，那就直接取current的
                offset = current;
            }
            current++;
        }
        return new String(chars, offset, dna.length());
    }

    public static String getRes2(String dna) {
        if (dna == null || dna.length() == 0) return dna;
        char[] chars = (dna + dna).toCharArray();
        // 偏移
        int offset = 0, current = 1;
        while (current < dna.length()) {
            if (chars[current] == chars[offset]) {
                boolean lower = false;
                for (int i = 0; i < dna.length(); i++) {
                    if (chars[current + i] == chars[offset + i]) {
                        continue;
                    }
                    lower = chars[current + i] < chars[offset + i];
                    break;
                }
                if (lower) {
                    offset = current;
                }
            } else if (chars[current] < chars[offset]) {
                offset = current;
            }
            current++;
        }
        return new String(chars, offset, dna.length());
    }

    /**
     * 优先队列：4,5,8,2,6
     * 4 -> 4
     * 4, 5 -> 4, 5
     * 4, 5, 8-> 4, 5, 8
     * 4, 5, 8, 2->2, 4, 5, 8
     * 4, 5, 8, 2, 6->2, 4, 5,6, 8
     */
    public static String getRes3(String dna) {
        if (dna == null || dna.length() == 0) return dna;
        char[] chars = (dna + dna).toCharArray();
        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < dna.length(); i++) {
            queue.offer(new String(chars, i, dna.length()));
        }
        return queue.peek();
    }

    // CBA -> ACB
    public static String getRes4(String dna) {
        if (dna == null || dna.length() == 0) return dna;
        char[] chars = (dna + dna).toCharArray();
        String[] strings = new String[dna.length()];
        for (int i = 0; i < dna.length(); i++) {
            strings[i] = new String(chars, i, dna.length());
        }
        Arrays.sort(strings);
        return strings[0];
    }

    public static String getRes5(String dna) {
        if (dna == null || dna.length() == 0) return dna;
        char[] chars = (dna + dna).toCharArray();
        String res = dna;
        for (int i = 1; i < dna.length(); i++) {
            String temp = new String(chars, i, dna.length());
            if (temp.compareTo(res) <= 0) {
                res = temp;
            }
        }
        return res;
    }
}
