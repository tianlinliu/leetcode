public class Solution {
    public int trap(int[] A) {
        if (A == null || A.length < 3) return 0;

        // find the max index
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > A[max]) {
                max = i;
            }
        }

        int result = 0;;
        // calculate the left half
        int leftMax = 0;
        for (int i = 0; i < max; i++) {
            if (A[i] > A[leftMax]) {
                leftMax = i;
            } else {
                result += A[leftMax] - A[i];
            }
        }

        // the right half
        int rightMax = A.length - 1;
        for (int i = rightMax; i > max; i--) {
            if (A[i] > A[rightMax]) {
                rightMax = i;
            } else {
                result += A[rightMax] - A[i];
            }
        }

        return result;
    }
}