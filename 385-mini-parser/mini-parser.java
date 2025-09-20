/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int index;
    NestedInteger dfs(String s) {
        if (index >= s.length()) return new NestedInteger();
        if (s.charAt(index) == '[') {
            index++;
            NestedInteger list = new NestedInteger();
            if (index < s.length() && s.charAt(index) == ']') {
                index++;
                return list;
            }

            while (index < s.length()) {
                list.add(dfs(s));

                if (index < s.length() && s.charAt(index) == ',') {
                    index++; 
                    continue;
                }
                if (index < s.length() && s.charAt(index) == ']') {
                    index++; 
                    break;
                }
            }
            return list;
        } else {
            int sign = 1;
            if (s.charAt(index) == '-') {
                sign = -1;
                index++;
            }
            int num = 0;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 + (s.charAt(index) - '0');
                index++;
            }
            return new NestedInteger(sign * num);
        }
    }
    public NestedInteger deserialize(String s) {
        index = 0;
        return dfs(s);
    }
}