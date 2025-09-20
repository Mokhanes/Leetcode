import java.util.*;

class Solution {
    public NestedInteger deserialize(String s) {
        // Case: just a single integer (no brackets)
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Deque<NestedInteger> stack = new ArrayDeque<>();
        NestedInteger current = null;
        int start = 0; // start index for numbers

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') {
                // new list starts
                if (current != null) {
                    stack.push(current);
                }
                current = new NestedInteger();
                start = i + 1;
            } else if (c == ',' || c == ']') {
                if (i > start) { // we have a number between start..i
                    int num = Integer.parseInt(s.substring(start, i));
                    current.add(new NestedInteger(num));
                }
                if (c == ']') {
                    if (!stack.isEmpty()) {
                        NestedInteger parent = stack.pop();
                        parent.add(current);
                        current = parent;
                    }
                }
                start = i + 1;
            }
        }

        return current;
    }
}
