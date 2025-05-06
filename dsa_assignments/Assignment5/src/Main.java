
public class Main {

    public static int quotient(int a, int b) {
        if (b == 0) throw new ArithmeticException("Divide by zero");
        boolean negative = (a < 0) ^ (b < 0);
        int q = quotientHelper(Math.abs(a), Math.abs(b));
        return negative ? -q : q;
    }

    private static int quotientHelper(int a, int b) {
        if (a < b) return 0;
        return 1 + quotientHelper(a - b, b);
    }

    public static int remainder(int a, int b) {
        if (b == 0) throw new ArithmeticException("Divide by zero");
        boolean negative = a < 0;
        int r = remainderHelper(Math.abs(a), Math.abs(b));
        return negative ? -r : r;
    }

    private static int remainderHelper(int a, int b) {
        if (a < b) return a;
        return remainderHelper(a - b, b);
    }

    public static int multiply(int a, int b) {
        if (b < 0) return -multiply(a, -b);
        if (b == 0) return 0;
        return a + multiply(a, b - 1);
    }

    public static void main(String[] args) {
        System.out.println(quotient(-17, 3));     // -5
        System.out.println(remainder(-17, 3));    // -2
        System.out.println(multiply(2, 9999));      // -24
    }
}
