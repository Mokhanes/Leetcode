class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<Integer> mod1 = new ArrayList<>();
        List<Integer> mod2 = new ArrayList<>();

        for (int n : nums) {
            sum += n;
            if (n % 3 == 1) mod1.add(n);
            else if (n % 3 == 2) mod2.add(n);
        }

        if (sum % 3 == 0) return sum;

        Collections.sort(mod1);
        Collections.sort(mod2);

        int option1 = Integer.MAX_VALUE;
        int option2 = Integer.MAX_VALUE;
        int remainder = sum % 3;

        if (remainder == 1) {
            if (!mod1.isEmpty()) option1 = mod1.get(0);
            if (mod2.size() >= 2) option2 = mod2.get(0) + mod2.get(1);
        } else {
            if (!mod2.isEmpty()) option1 = mod2.get(0);
            if (mod1.size() >= 2) option2 = mod1.get(0) + mod1.get(1);
        }

        return sum - Math.min(option1, option2);
    }
}
