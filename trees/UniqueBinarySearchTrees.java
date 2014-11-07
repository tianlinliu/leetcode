public class UniqueBinarySearchTrees {
    /*
    numTrees[n] = numTree[0] * numTree[n]
                + numTree[1] * numTree[n - 1]
                + ...
                + numTree[n] * numTree[0]

    numTree(n)
        cache = int[n + 1]
        cache[0] = 1
        cache[1] = 1

        for i = 2 to n
            for j = 0 to i - 1
                cache[i] += cache[j] * cache[i - j]
    */
    public int numTrees(int n) {
        if (n < 0) return -1;
        if (n == 0 || n == 1) return 1;

        int[] cache = new int[n + 1]; // size = n + 1
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                cache[i] += cache[j] * cache[i - 1 - j];
            }
        }

        return cache[n];
    }
}