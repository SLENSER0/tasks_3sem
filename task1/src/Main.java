// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.print("0. ");
        System.out.println(convert(5));
        System.out.print("1. ");
        System.out.println(fitCalc(41,3));
        System.out.print("2. ");
        System.out.println(containers(4,1,4));
        System.out.print("3. ");
        System.out.println(triangleType(5,1,-1));
        System.out.print("4. ");
        System.out.println(ternaryEvaluation(11,10));
        System.out.print("5. ");
        System.out.println(howManyItems(100,2,2));
        System.out.print("6. ");
        System.out.println(factorial(5));
        System.out.print("7. ");
        System.out.println(gcd(259,28));
        System.out.print("8. ");
        System.out.println(ticketSaler(24,950));
        System.out.print("9. ");
        System.out.println(tables(123,58));
    }
    public static double convert(int n)
    {
        return n * 3.785d;
    }
    public static int fitCalc(int n, int m) {
        return n * m;
    }
    public static int containers(int n, int m, int k) {
        return 20 * n + 50 * m + 100 * k;
    }
    public static String triangleType(double x, double y, double z) {
        if ((x + y < z) || (x + z < y) || (y + z < x) || x <= 0 || y <= 0 || z <=  0) {
            return "not a triangle";
        } else if (x == y && y == z){
            return "isosceles";
        } else if (x == y || y == z || x == z) {
            return "equilateral";
        } else {
            return "different-sided";
        }
    }
    public static double ternaryEvaluation(double a, double b) {

        return (a >= b) ? a : b;
    }
    public static int howManyItems(double x, double y, double z) {
        return (int)(x / (2*y*z));
    }
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n-1)*n;
        }
    }
    public static int gcd(int x, int y) {
        if (x == y) {
            return x;
        } else {
            if (x > y) {
                return gcd(x-y,y);
            } else {
                return gcd(x,y-x);
            }
        }
    }
    public static double ticketSaler(double x, double y) {
        return x*y*0.72;
    }
    public static int tables(double x, double y) {
        if (x - 2*y > 0) {
            return (int) Math.ceil((x - 2 * y) / 2);
        }
        else {
            return 0;
        }
    }

}