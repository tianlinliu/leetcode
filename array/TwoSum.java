import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length < 2) return result;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            if (!map.containsKey(key)) {
                map.put(numbers[i], i);
            } else {
                result[0] = map.get(key) + 1;
                result[1] = i + 1;
                break;
            }
        }
        return result;
    }
}