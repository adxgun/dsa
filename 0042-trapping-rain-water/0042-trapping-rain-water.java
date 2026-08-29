class Solution {
    public int trap(int[] height) {
        int water = 0, left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) leftMax = Math.max(leftMax, height[left]);
                else water += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = Math.max(rightMax, height[right]);
                else water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}