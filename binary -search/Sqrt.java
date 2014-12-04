public class Sqrt {
    public int sqrt(int x) {
        if (x <= 0) return x;

        long lo = 0;
        long hi = x;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (x < mid * mid) {
                hi = mid - 1; //?
            } else {
                lo = mid + 1;
            }
        }

        return (int)hi; //?
    }
}