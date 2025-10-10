class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0.0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = area(points[i], points[j], points[k]);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }
    
    private double area(int[] A, int[] B, int[] C) {
        return 0.5 * Math.abs(
            A[0] * (B[1] - C[1]) +
            B[0] * (C[1] - A[1]) +
            C[0] * (A[1] - B[1])
        );
    }
}