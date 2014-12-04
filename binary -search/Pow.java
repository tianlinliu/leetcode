public class Pow {
    public double pow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1.0;
        if (n == 1) return x;

        boolean neg = false;
        if (n < 0) {
            neg = true;
            n = -n;
        }

        double half = pow(x, n / 2);
        double odd = 1;
        if (n % 2 != 0) {
            odd = x;
        }

        double result = half * half * odd;
        if (neg) {
            return 1 / result;
        }
        return result;
    }
}