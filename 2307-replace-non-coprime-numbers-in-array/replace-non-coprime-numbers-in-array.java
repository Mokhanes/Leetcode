import java.util.*;

public class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Long> stack = new Stack<>();
        
        for (int num : nums) {
            stack.push((long) num);
            
            // keep merging while top two are non-coprime
            while (stack.size() > 1) {
                long a = stack.get(stack.size() - 2);
                long b = stack.peek();
                long g = gcd(a, b);
                
                if (g > 1) { // non-coprime
                    long lcm = (a * b) / g;
                    stack.pop();               // remove top
                    stack.pop();               // remove second top
                    stack.push(lcm);           // push lcm
                } else {
                    break;
                }
            }
        }
        
        // convert stack back to List<Integer>
        List<Integer> result = new ArrayList<>();
        for (long val : stack) {
            result.add((int) val);
        }
        return result;
    }
    
    // helper gcd
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
