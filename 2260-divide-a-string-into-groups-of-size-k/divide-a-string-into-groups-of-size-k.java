import java.util.*;

class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> li = new ArrayList<>();

        // split into chunks of size k
        for (int i = 0; i + k <= s.length(); i += k) {
            li.add(s.substring(i, i + k));
        }

        int c = s.length() % k;

        // handle last incomplete chunk
        if (c != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(s.length() - c)); // leftover chars

            // add fillers (k - c times)
            for (int i = 0; i < k - c; i++) {
                sb.append(fill);
            }
            li.add(sb.toString());
        }

        return li.toArray(new String[0]);
    }
}
