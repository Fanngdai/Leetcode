class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length-1, up = 0, down = matrix.length-1;
        List<Integer> rtn = new ArrayList<>();
        
        while(left <= right && up <= down) {
            moveRight(matrix, left, right, up, rtn);
            up++;
            if(left <= right && up <= down)
                moveDown(matrix, up, down, right, rtn);
            right--;
            if(left <= right && up <= down)
                moveLeft(matrix, left, right, down, rtn);
            down--;
            if(left <= right && up <= down)
                moveUp(matrix, up, down, left, rtn);
            left++;
        }
            
        return rtn;
    }
    
    private void moveRight(int[][] matrix, int left, int right, int up, List<Integer> lst) {
        for(int i=left; i<=right; i++) {
            lst.add(matrix[up][i]);
        }
    }
    
    private void moveDown(int[][] matrix, int up, int down, int right, List<Integer> lst) {
        for(int i=up; i<=down; i++) {
            lst.add(matrix[i][right]);
        }
    }
    
    private void moveLeft(int[][] matrix, int left, int right, int down, List<Integer> lst) {
        for(int i=right; i>=left; i--) {
            lst.add(matrix[down][i]);
        }
    }
    
    private void moveUp(int[][] matrix, int up, int down, int left, List<Integer> lst) {
        for(int i=down; i>=up; i--) {
            lst.add(matrix[i][left]);
        }
    }
}

// [[1,2,3],[4,5,6],[7,8,9]]
// [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// [[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15]]
// [[1,2,3],[4,5,6],[7,8,9],[10,11,12]]
// [[1,2,3],[4,5,6],[7,8,9],[10,11,12],[13,14,15]]