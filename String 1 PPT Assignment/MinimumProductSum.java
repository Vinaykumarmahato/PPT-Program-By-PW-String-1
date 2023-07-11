import java.util.Arrays;

public class MinimumProductSum {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int n = nums1.length;
        int minProduct = 0;
        
        for (int i = 0; i < n; i++) {
            minProduct += nums1[i] * nums2[n - i - 1];
        }
        
        return minProduct;
    }
    
    public static void main(String[] args) {
        MinimumProductSum minimumProductSum = new MinimumProductSum();
        
        // Example usage
        int[] nums1 = {5, 3, 4, 2};
        int[] nums2 = {4, 2, 2, 5};
        int minProduct = minimumProductSum.minProductSum(nums1, nums2);
        System.out.println("Minimum product sum: " + minProduct);
    }
}
