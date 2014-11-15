public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null || n == 0 || A.length < m + n) return;

        int[] AOrin = Arrays.copyOf(A, m); // Arrays.copyOf(int[] a, int newLength)
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (AOrin[i] <= B[j]) {
                A[k++] = AOrin[i++];
            } else {
                A[k++] = B[j++];
            }
        }

        while (i < m) {
            A[k++] = AOrin[i++];
        }
        while (j < n) {
            A[k++] = B[j++];
        }
    }

    public void merge_better(int A[], int m, int B[], int n) {
        if (A == null || B == null || A.length < m + n || n == 0) return;

        int len = m + n;
        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[--len] = A[--m];
            } else {
                A[--len] = B[--n];
            }
        }

        while (n > 0) {
            A[--len] = B[--n];
        }
    }
}