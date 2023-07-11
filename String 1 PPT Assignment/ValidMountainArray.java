public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        
        if (n < 3) {
            return false;
        }
        
        int i = 0;
        
        // Increasing phase
        while (i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }
        
        if (i == 0 || i == n - 1) {
            return false;
        }
        
        // Decreasing phase
        while (i < n - 1 && arr[i] > arr[i + 1]) {
            i++;
        }
        
        return i == n - 1;
    }
    
    public static void main(String[] args) {
        ValidMountainArray validMountainArray = new ValidMountainArray();
        
        // Example usage
        int[] arr = {2, 1};
        boolean isValid = validMountainArray.validMountainArray(arr);
        System.out.println("Is valid mountain array: " + isValid);
    }
}
