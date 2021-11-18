package task3912;

/* 
Максимальная площадь
Реализуй метод int maxSquare(int[][] matrix), возвращающий площадь самого большого квадрата состоящего из единиц в двумерном массиве matrix.
Массив matrix заполнен только нулями и единицами.
*/

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 0, 0}
        };
        System.out.println(maxSquare(matrix));
    }

    public static int maxSquare(int[][] matrix) {
        int maxSide = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int length = 0;
                if (matrix[i][j] == 1) {
                    if (maxSide == 0) maxSide = 1;
                    length++;
                    for (int k = 1; k < matrix[i].length - j; k++) {
                        if (matrix[i][j + k] == 1) {
                            length++;
                            if (length > maxSide && isSquare(matrix, i, j, length)) {
                                maxSide = length;
                            }
                        } else {
                            j += length - 1;
                            break;
                        }
                    }
                }
            }
        }
        return maxSide * maxSide;
    }

    public static boolean isSquare(int[][] matrix, int i, int j, int length) {
        if (i + length > matrix.length) return false;
        for (int l = i + 1; l < i + length; l++) {
            for (int m = j; m < j + length; m++) {
                if (matrix[l][m] == 0) return false;
            }
        }
        return true;
    }
}
