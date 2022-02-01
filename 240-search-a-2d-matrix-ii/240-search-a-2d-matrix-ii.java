class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length-1, rowLen = matrix.length;
        
        while(row < rowLen && col >= 0) {
            if(matrix[row][col] == target) return true;
            
            if(matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        
        return false;
    }
}