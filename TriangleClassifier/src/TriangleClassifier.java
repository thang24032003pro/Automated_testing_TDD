public class TriangleClassifier {

    public static String classify(int a, int b, int c) {
        if (!isTriangle(a, b, c)) {
            return "không phải là tam giác";
        }
        if (a == b && b == c) {
            return "tam giác đều";
        }
        if (a == b || b == c || a == c) {
            return "tam giác cân";
        }
        return "tam giác thường";
    }

    private static boolean isTriangle(int a, int b, int c) {
        return (a > 0 && b > 0 && c > 0) && (a + b > c && b + c > a && a + c > b);
    }
}