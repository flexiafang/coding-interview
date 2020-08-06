package 面试题04_二维数组中的查找;

/**
 * @Author hustffx
 * @Date 2020/8/6
 */
public class FindInPartiallySortedMatrix {

    public boolean findNumberInMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            int num = matrix[row][col];

            if (num == target) {
                return true;
            } else if (num > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}
