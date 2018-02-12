package strings;

public class RotateMatrix{
  public static void main(String args[]) {
    int[][] b = {{00, 01, 02, 03},
                 {10, 11, 12, 13},
                 {20, 21, 22, 23},
                 {30, 31, 32, 33}};

    int[][] a = {{1, 2, 3},
                 {4, 5, 6},
                 {7, 8, 9}};
    printMatrix(rotateMatrix(a));
  }

  public static int[][] rotateMatrix(int[][] matrix) {
    int depth = matrix.length/2;
    int layer = matrix.length -1;
    int matrixLength = matrix.length - 1;
    for(int d = 0; d < depth; d++) {
      for(int l = 1; l <= layer; l++) {

        int tmp = matrix[d][l];
        matrix[d][l] = matrix[l][d];

        int tmp2 = matrix[l][matrixLength - d];
        matrix[l][matrixLength -d] = tmp;

        tmp = matrix[matrixLength - d][l];
        matrix[matrixLength - d][l] = tmp2;

        matrix[l][d] = tmp;
      }
    }
    return matrix;
  }

  private static void printMatrix(int[][]a) {
    for(int i = 0; i < a.length; i++) {
      for(int j = 0; j < a.length; j++) {
        System.out.print(a[i][j]+ " ,");
      }
      System.out.println();
    }
  }
}

