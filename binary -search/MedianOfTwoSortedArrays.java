public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if (A == null || B == null || (A.length == 0 && B.length == 0)) return 0;

        int m = A.length;
        int n = B.length;
        if (m == 0 && n == 1) return B[0];
        if (m == 1 && n == 0) return A[0];
        int k = (m + n) / 2;
        int[] AB = new int[k + 1];

        int pa = 0;
        int pb = 0;
        for (int i = 0; i < k + 1; i++) {
            if (pb >= B.length) {
                AB[i] = A[pa++];
            } else if (pa >= A.length) {
                AB[i] = B[pb++];
            } else if (A[pa] <= B[pb]) {
                AB[i] = A[pa++];
            } else {
                AB[i] = B[pb++];
            }
        }

        double median = 0;
        if ((m + n) % 2 == 0) {
            median = (AB[k] + AB[k - 1]) / 2.0; // divisor should be double type!
        } else {
            median = AB[k]; // not k - 1
        }

        return median;
    }

    public double findMedianSortedArrays(int[] A, int[] B) {

    }
}