class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();
        stack.push(0); 

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop(); 
            }
            if (stack.isEmpty() || stack.peek() < num) {
                ans++;
                stack.push(num);
            }
        }
        return ans;
    }
}
