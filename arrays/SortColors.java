public class SortColors {
    public void sortColors(int[] A) {
        if (A == null || A.length <= 1) return;

        int zeroP = 0;
        int twoP = A.length - 1;
        int cur = 0;
        while (cur <= twoP) {
            if (A[cur] == 2) {
                swap(A, cur, twoP--);
                /*
                while (twoP >= zeroP && A[twoP] == 2) {
                    twoP--;
                }
                */
            } else if (A[cur] == 0) {
                swap(A, cur++, zeroP++);
                /*
                while (zeroP <= twoP && A[zeroP] == 0) {
                    zeroP++;
                    cur++;
                }
                */
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] a, int one, int two) {
        int temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}