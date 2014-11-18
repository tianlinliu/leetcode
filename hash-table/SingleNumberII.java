public class SingleNumberII {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) return -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else if (map.get(A[i]) == 2) {
                map.remove(A[i]);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
            }
        }

        return map.keySet().iterator().next();
    }
}