class Solution {
    
    public int diagonalSum(int[][] mat) {
        
        int n = mat.length; 
        
        int totalSum = 0; 
        
        for (int i = 0; i < n; i++) {
            
            totalSum += mat[i][i];
            
            if (i != n - 1 - i) {
                totalSum += mat[i][n - 1 - i];
            }
        }
        
        return totalSum;
    }
}