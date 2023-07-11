import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructArray {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0];
        }
        
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> originalList = new ArrayList<>();
        
        for (int num : changed) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        for (int num : changed) {
            if (countMap.getOrDefault(num, 0) == 0) {
                continue;
            }
            
            int doubleNum = num * 2;
            
            if (countMap.getOrDefault(doubleNum, 0) == 0) {
                return new int[0];
            }
            
            originalList.add(num);
            
            countMap.put(num, countMap.get(num) - 1);
            countMap.put(doubleNum, countMap.get(doubleNum) - 1);
        }
        
        int[] originalArray = new int[originalList.size()];
        for (int i = 0; i < originalList.size(); i++) {
            originalArray[i] = originalList.get(i);
        }
        
        return originalArray;
    }
    
    public static void main(String[] args) {
        ReconstructArray reconstructArray = new ReconstructArray();
        
        // Example usage
        int[] changed = {1, 3, 4, 2, 6, 8};
        int[] original = reconstructArray.findOriginalArray(changed);
        System.out.println("Original array: " + java.util.Arrays.toString(original));
    }
}
