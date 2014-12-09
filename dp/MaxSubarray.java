public class MaxSubarray {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) return 0;

        int maxEndHere = A[0];
        int maxSoFar = A[0];
        for (int i = 1; i < A.length; i++) {
            maxEndHere = Math.max(A[i], maxEndHere + A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndHere); // update max sum so far
        }

        return maxSoFar;
    }

    public int maxSubArray_dp(int[] A) {
        if (A == null || A.length == 0) return 0;

        int[] maxSum = new int[A.length];
        maxSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            maxSum[i] = Math.max(A[i - 1], A[i - 1] + A[i]);
        }
    }
}