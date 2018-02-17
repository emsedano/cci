package strings;

public class RotateMatrix{
    public static void main(String args[]) {
        int[][] b = {{00, 01, 02, 03},
                {10, 11, 12, 13},
                {20, 21, 22, 23},
                {30, 31, 32, 33}};

        String[][] a = {{"00", "01", "02" },
                        {"10", "11", "12" },
                        {"20", "21", "22" }};

        String[][] c = {{"20", "10", "00" },
                        {"21", "11", "01" },
                        {"22", "12", "02" }};
        printMatrix(rotateMatrix(a));
    }

    public static String[][] rotateMatrix(String[][] matrix) {
        int depth = matrix.length/2;
        int matrixLength = matrix.length - 1;
        for (int layer = 0; layer < depth; layer++) {
            int first  =  layer;
            int last = matrixLength - layer;
            for(int i = first; i < last; i++) {
                int offset = i - first;

                String top = matrix[first][i];

                // left - top
                matrix[first][i] = matrix[last - offset][first];

                // bottom - left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last -offset] = matrix[i][last];

                // top - right
                matrix[i][last] = top;
            }
        }
        return matrix;
    }

    private static void printMatrix(String[][]a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                System.out.print(a[i][j]+ " ,");
            }
            System.out.println();
        }
    }
}
