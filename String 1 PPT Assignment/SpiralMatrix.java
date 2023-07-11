public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        
        while (num <= n * n) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }
            
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        
        return matrix;
    }
    
    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        
        // Example usage
        int n = 3;
        int[][] matrix = spiralMatrix.generateMatrix(n);
        
        // Print the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
