public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;

        int size = triangle.size();
        Integer[] cache = triangle.get(size - 1).toArray(new Integer[size]);
        for (int levelNum = size - 2; levelNum >= 0; levelNum--) {
            List<Integer> level = triangle.get(levelNum);
            for (int i = 0; i <= levelNum; i++) {
                cache[i] = Math.min(cache[i], cache[i + 1]) + level.get(i);
            }
        }

        return cache[0];
    }
}