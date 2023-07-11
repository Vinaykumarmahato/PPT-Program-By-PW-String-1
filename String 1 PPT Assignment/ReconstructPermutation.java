public class ReconstructPermutation {
    public int[] findPermutation(String s) {
        int n = s.length();
        int[] perm = new int[n + 1];
        
        // Initialize the permutation with consecutive numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            perm[i] = i;
        }
        
        // Apply the transformations based on the string s
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == 'D') {
                int j = i;
                while (i < n && s.charAt(i) == 'D') {
                    i++;
                }
                reverse(perm, j, i);
            } else {
                i++;
            }
        }
        
        return perm;
    }
    
    private void reverse(int[] perm, int start, int end) {
        while (start < end) {
            int temp = perm[start];
            perm[start] = perm[end];
            perm[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        ReconstructPermutation reconstructPermutation = new ReconstructPermutation();
        
        // Example usage
        String s = "IDID";
        int[] perm = reconstructPermutation.findPermutation(s);
        System.out.println("Permutation: " + java.util.Arrays.toString(perm));
    }
}
