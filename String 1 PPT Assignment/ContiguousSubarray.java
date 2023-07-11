import java.util.HashMap;
import java.util.Map;

public class ContiguousSubarray {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int count = 0;
        
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;
            
            if (countMap.containsKey(count)) {
                maxLength = Math.max(maxLength, i - countMap.get(count));
            } else {
                countMap.put(count, i);
            }
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        ContiguousSubarray contiguousSubarray = new ContiguousSubarray();
        
        // Example usage
        int[] nums = {0, 1};
        int maxLength = contiguousSubarray.findMaxLength(nums);
        System.out.println("Maximum length: " + maxLength);
    }
}
