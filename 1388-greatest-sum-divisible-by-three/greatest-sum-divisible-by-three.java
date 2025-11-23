class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int min1 = Integer.MAX_VALUE, secondMin1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE, secondMin2 = Integer.MAX_VALUE;

        for (int n : nums) {
            sum += n;
            int r = n % 3;
            if (r == 1) {
                if (n < min1) {
                    secondMin1 = min1;
                    min1 = n;
                } else if (n < secondMin1) {
                    secondMin1 = n;
                }
            } else if (r == 2) {
                if (n < min2) {
                    secondMin2 = min2;
                    min2 = n;
                } else if (n < secondMin2) {
                    secondMin2 = n;
                }
            }
        }

        int remainder = sum % 3;
        if (remainder == 0) return sum;

        int option1 = Integer.MAX_VALUE, option2 = Integer.MAX_VALUE;

        if (remainder == 1) {
            option1 = min1;
            if (min2 != Integer.MAX_VALUE && secondMin2 != Integer.MAX_VALUE)
                option2 = min2 + secondMin2;
        } else {
            option1 = min2;
            if (min1 != Integer.MAX_VALUE && secondMin1 != Integer.MAX_VALUE)
                option2 = min1 + secondMin1;
        }

        return sum - Math.min(option1, option2);
    }
}
