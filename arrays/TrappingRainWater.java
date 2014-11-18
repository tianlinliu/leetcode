import java.util.*;

public class TrappingRainWater {
    public static int trap(int[] A) {
        if (A == null || A.length <= 1) return 0;

        int result = 0;
        int i = 0;
        while (i < A.length - 1 && A[i + 1] >= A[i]) {
            i++;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(i++);
        while (i < A.length) {
            if (A[i] > A[i - 1] && (i == (A.length - 1) || A[i] >= A[i + 1])) {
                int bars = 0;
                int lastPop = 0;
                while (!stack.empty() && A[stack.peek()] <= A[i]) {
                    lastPop = stack.pop();
                    bars += A[lastPop];
                    System.out.println(lastPop);
                    System.out.println(bars);
                }

                result += Math.min(A[lastPop], A[i]) * (i - lastPop) - bars;
                i++;
            } else {
                stack.push(i++);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 3};
        System.out.println(trap(a));
    }
}