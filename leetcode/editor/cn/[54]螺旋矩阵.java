//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1807 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 1. 计算二维数组中所有元素的总数
        int m = matrix.length;
        int n = matrix[0].length;
        int total = 0;
        for (int[] row : matrix) {
            total += row.length;
        }

        // 2. 创建一个一维数组，长度等于二维数组中所有元素的总数
        List<Integer> output = new ArrayList<>();

        // 3. 顺时针螺旋顺序遍历
        int r1 = 0, r2 = m - 1, c1 = 0, c2 = n - 1;
        while (r1 <= r2 && c1 <= c2) {
            // 遍历第一行
            for (int j = c1; j <= c2; j++) {
                output.add(matrix[r1][j]);
            }
            r1++;

            // 遍历最后一列
            for (int i = r1; i <= r2; i++) {
                output.add(matrix[i][c2]);
            }
            c2--;

            // 检查是否需要继续遍历
            if (r1 <= r2) {
                // 遍历最后一行
                for (int j = c2; j >= c1; j--) {
                    output.add(matrix[r2][j]);
                }
                r2--;
            }

            // 检查是否需要继续遍历
            if (c1 <= c2) {
                // 遍历第一列
                for (int i = r2; i >= r1; i--) {
                    output.add(matrix[i][c1]);
                }
                c1++;
            }
        }

        return output;
}
//leetcode submit region end(Prohibit modification and deletion)
