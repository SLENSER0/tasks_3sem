import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.print("0. ");
        System.out.println(duplicateChars("apple"));
        System.out.print("1. ");
        System.out.println(getInitials("Barack Obama"));
        System.out.print("2. ");
        System.out.println(differenceEvenOdd(new int[] {22, 50, 16, 63, 31, 55}));
        System.out.print("3. ");
        System.out.println(equalToAvg(new int[] {1, 2, 3, 4, 6}));
        System.out.print("4. ");
        System.out.println((Arrays.toString(indexMult(new int[] {3, 3, -2, 408, 3, 31}))));
        System.out.print("5. ");
        System.out.println(reverse("The quick brown fox."));
        System.out.print("6. ");
        System.out.println(Tribonacci(7));
        System.out.print("7. ");
        System.out.println(pseudoHash(10));
        System.out.print("8. ");
        System.out.println(botHelper("help!"));
        System.out.print("9. ");
        System.out.println(isAnagram("hello", "world"));
    }
    public static boolean duplicateChars(String string) {
        string = string.toLowerCase();
        for (int i = 0; i < string.length(); i++) {
            for (int j = 0; j < i;j++)
                if (string.charAt(i) == string.charAt(j))
                    return true;
        }
        return false;
    }

    public static String getInitials(String string) {
        String [] strings = string.split(" ");
        return  ""+strings[0].charAt(0)+strings[1].charAt(0);
    }

    public static int differenceEvenOdd(int[] values) {
        int answer = 0;
        for (int i = 0; i < values.length; i++) {
            answer += (int) (values[i] * Math.pow(-1,i));
        }
        return answer;
    }

    public static boolean equalToAvg(int[] values) {
        int sum = 0;
        for (int element : values)
            sum += element;
        float average = (float) sum / values.length;
        for (int element : values) {
            if (element == average) {
                return true;
            }
        }
        return false;

    }

    public static int[] indexMult(int[] values) {
        int[] new_values = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            new_values[i] = values[i] * i;
        }
        return new_values;
    }

    public static  String reverse(String string) {
        String s = "";

        for (int i=string.length()-1; i>=0; i--)
        {
            s += string.charAt(i);
        }
        return s;
    }
    public static int Tribonacci(int x) {
        if (x == 0)
            return 0;
        else if (x == 1)
            return 0;
        else if (x == 2)
            return 1;
        else
            return Tribonacci(x-1) + Tribonacci(x -2) + Tribonacci(x-3);
    }
    public static String pseudoHash(int x) {
        Random rand = new Random();
        String str = "abcdef0123456789";
        String hash = "";
        for (int i = 0; i < x; i++) {
            int rand_int = rand.nextInt(str.length());
            hash += str.charAt(rand_int);
        }
        return hash;
    }
    public static String botHelper(String str) {
        str = str.replaceAll("[!,.?()$#]", "");
        String[] strs = str.split(" ");
        for (String element : strs) {
            if (element.equalsIgnoreCase("help")) {
                return "Calling for a staff member";
            }
        }
        return "Keep waiting";

    }

    public static boolean isAnagram(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2);
    }
}