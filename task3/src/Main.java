import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("1--------------------");
        System.out.println(replaceVowels("apple"));
        System.out.println(replaceVowels("Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println("2--------------------");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println("3--------------------");
        System.out.println(doesBlockFit(1,3,5,4,5));
        System.out.println(doesBlockFit(1,8,1,1,1));
        System.out.println(doesBlockFit(1,2,2,1,1));
        System.out.println("4--------------------");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println("5--------------------");
        System.out.println(countRoots(new int[] {1, -3, 2}));
        System.out.println(countRoots(new int[] {2, 5, 2}));
        System.out.println(countRoots(new int[] {1, -6, 9}));
        System.out.println("6--------------------");
        System.out.println(Arrays.toString(salesData(new String[][] {
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}
        })));    System.out.println(Arrays.toString(salesData(new String[][] {
                {"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
        })));
        System.out.println("7--------------------");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("ab aa aa ac"));
        System.out.println("8--------------------");
        System.out.println(waveForm(new int[] {3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int[] {1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[] {1, 2, -6, 10, 3}));
        System.out.println("9--------------------");
        System.out.println(commonVowel("Hello world"));
        System.out.println(commonVowel("Actions speak louder than words."));
        System.out.println("10--------------------");
        System.out.println(Arrays.deepToString(dataScience(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}})));
        System.out.println("---------------------");
    }

    public static String replaceVowels(String str) {
        return str.replaceAll("[aeiouyAEIOUY]", "*");
    }
    public static String stringTransform(String str) {
        str = str.replaceAll("([a-zA-Z])\\1", "*$1");
        char[] myStr = str.toCharArray();
        for (int i = 0; i < str.length()-1; i++) {
            if (myStr[i] == '*') {
                myStr[i+1] = Character.toUpperCase(myStr[i+1]);
            }
        }
        str = String.valueOf(myStr);
        return str.replaceAll("[*]", "Double");
    }

    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {

        int[] parallelepipedDimensions = new int[] {a,b,c};
        int[] holeDimensions = new int[] {w,h};
        Arrays.sort(parallelepipedDimensions);
        Arrays.sort(holeDimensions);

        for (int i = 0; i < holeDimensions.length; i++) {
            if (parallelepipedDimensions[i] > holeDimensions[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean numCheck(int n) {
        int s = 0;
        int isOdd = n % 2;

        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s % 2 == isOdd;
    }

    public static int countRoots(int[] coefficients) {
        int a = coefficients[0];
        int b = coefficients[1];
        int c = coefficients[2];
        int d = b*b-4*a*c;



        if (d < 0)
            return 0;

        double x1 = (-b+Math.sqrt(d))/(2*a);
        double x2 = (-b-Math.sqrt(d))/(2*a);

        if (d == 0)
            return (Math.floor(x1) == x1 ? 1 : 0);

        return (Math.floor(x1) == x1 ? 1 : 0) + (Math.floor(x2) == x2 ? 1 : 0);
    }
    public static String[] salesData(String[][] sales) {
        String[] answer = new String[100];
        Set<String> stores = new HashSet<>();
        int[] n = new int[100];
        int answerIndex = 0;

        for (int i = 0; i < sales.length; i++) {
            for (int j = 1; j < sales[i].length; j++) {
                stores.add(sales[i][j]);
                n[i] += 1;
            }
        }
        for (int i = 0; i < sales.length; i++) {
            if (n[i] == stores.size()) {
                answer[answerIndex++] = sales[i][0];
            }
        }
        return Arrays.copyOf(answer, answerIndex);
    }

    public static boolean validSplit(String sentence) {
        String[] words = sentence.split(" ");
        boolean[] used = new boolean[words.length];

        return isValidSplit(words, used, 0);
    }

    private static boolean isValidSplit(String[] words, boolean[] used, int currentIndex) {
        if (currentIndex == words.length - 1) {
            return true;
        }

        for (int i = 0; i < words.length; i++) {
            if (!used[i] && (currentIndex == 0 || words[currentIndex - 1].charAt(words[currentIndex - 1].length() - 1) == words[i].charAt(0))) {
                used[i] = true;
                if (isValidSplit(words, used, currentIndex + 1)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }


    public static boolean waveForm(int[] numbers) {
        for (int i = 2; i < numbers.length-2; i++) {
            if ((numbers[i-2] <= numbers[i-1]) && (numbers[i-1] <= numbers[i])) {
                return false;
            }
            if ((numbers[i-2] >= numbers[i-1]) && (numbers[i-1] >= numbers[i])) {
                return false;
            }
        }
        return true;
    }

    public static char commonVowel(String str) {
        str = str.toLowerCase();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('a',0);
        map.put('e',0);
        map.put('i',0);
        map.put('o',0);
        map.put('u',0);
        map.put('y',0);
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            switch (c) {
                case 'a' -> map.put('a', map.get('a') + 1);
                case 'e' -> map.put('e', map.get('e') + 1);
                case 'i' -> map.put('i', map.get('i') + 1);
                case 'o' -> map.put('o', map.get('o') + 1);
                case 'u' -> map.put('u', map.get('u') + 1);
                case 'y' -> map.put('y', map.get('y') + 1);
                default -> {
                }
            }
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static int[][] dataScience(int [][] data) {
        int n = data.length;
        for (int i = 0; i < n; i++) {
            int average = 0;
            for (int[] datum : data) {
                average += datum[i];
            }
            average /= 5;
            data[i][i] = average;
        }
        return data;
    }


}
