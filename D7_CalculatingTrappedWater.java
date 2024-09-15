import java.util.Scanner;
public class TrappedRainWater{

    public static int trap(int[] height) {
        // Base condition: if the array has less than 3 bars, no water can be trapped
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0;              // Pointer starting from the left
        int right = height.length - 1; // Pointer starting from the right
        int leftMax = 0;           // Maximum height encountered on the left
        int rightMax = 0;          // Maximum height encountered on the right
        int totalWater = 0;        // Total water trapped

        while (left < right) {
            // Process the left side
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    // Update the maximum height on the left
                    leftMax = height[left];
                } else {
                    // Water trapped is determined by the difference between leftMax and the current height
                    totalWater += leftMax - height[left];
                }
                // Move the left pointer to the right
                left++;
            } else {
                // Process the right side
                if (height[right] >= rightMax) {
                    // Update the maximum height on the right
                    rightMax = height[right];
                } else {
                    // Water trapped is determined by the difference between rightMax and the current height
                    totalWater += rightMax - height[right];
                }
                // Move the right pointer to the left
                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size =sc.nextInt();
        int[] heights = new int[size];
        for(int i=0;i<size;i++)
          {
            heights[i]=sc.nextInt();
          }
        System.out.println("Total water trapped: " + trap(heights) + " units");
    }
}
