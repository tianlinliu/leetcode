public class SingleNumber {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) return -1;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (!set.add(A[i])) {
                set.remove(A[i]);
            }
        }

        return set.iterator().next();
    }
}