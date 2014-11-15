public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return -1;

        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > max) {
                max = area;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        /*
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if (area > max) {
                    max = area;
                }
            }
        }
        */

        return max;
    }
}