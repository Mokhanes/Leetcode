import java.util.*;

public class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        
        // Allowed business lines
        Set<String> allowed = new HashSet<>(
            Arrays.asList("electronics", "grocery", "pharmacy", "restaurant")
        );
        
        // List of indices that are valid
        List<Integer> valid = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (!isActive[i]) continue;                           // must be active
            if (!allowed.contains(businessLine[i])) continue;     // must be allowed business line
            if (!isValid(code[i])) continue;                      // must be valid format
            valid.add(i);
        }
        
        // Sort by business line -> coupon code
        Collections.sort(valid, (i1, i2) -> {
            int cmp = businessLine[i1].compareTo(businessLine[i2]);
            if (cmp != 0) return cmp;
            return code[i1].compareTo(code[i2]);
        });
        
        // Build result
        List<String> result = new ArrayList<>();
        for (int idx : valid) {
            result.add(code[idx]);
        }
        return result;
    }
    
    // Check coupon string validity
    private boolean isValid(String s) {
        if (s == null || s.isEmpty()) return false;
        for (char ch : s.toCharArray()) {
            if (!Character.isLetterOrDigit(ch) && ch != '_') {
                return false;
            }
        }
        return true;
    }
}
