public class RemoveDuplicates {
    public int removeDuplicates(int[] A) {
        if (A == null) return 0;
        if (A.length < 2) return A.length;

        int index = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[index]) {
                A[++index] = A[i];
            }
        }

        return index + 1;
    }
}