import java.util.ArrayList;
import java.util.List;

public class SparseMatrixMultiplication {
    public static int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int n = mat2[0].length;
        int[][] res = new int[m][n];
        List<List<Integer>> row_values = new ArrayList<>();
        List<List<Integer>> col_values = new ArrayList<>();
        List<List<Integer>> col_valuesb = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            row_values.add(new ArrayList<>());
            for (int j = 0; j < mat1[0].length; j++) {
                if (mat1[i][j] != 0) {
                    row_values.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < mat2[0].length; i++) {
            col_values.add(new ArrayList<>());
            col_valuesb.add(new ArrayList<>());
            for (int j = 0; j < mat2.length; j++) {
                if (mat2[j][i] != 0) {
                    col_values.get(i).add(j);
                    col_valuesb.get(i).add(mat2[j][i]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            List<Integer> row_value = row_values.get(i);
            for (int k = 0; k < row_value.size(); k++) {
                int col_idx = row_value.get(k);
                List<Integer> col_value = col_values.get(col_idx);
                List<Integer> col_valueb = col_valuesb.get(col_idx);
                for (int j = 0; j < col_value.size(); j++) {
                    res[i][col_value.get(j)] += mat1[i][col_idx] * col_valueb.get(j);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] mat1 = {{1, 0, 0}, {-1, 0, 3}};
        int[][] mat2 = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};

        int[][] result = multiply(mat1, mat2);

        // Print the result
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
