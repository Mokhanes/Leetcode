class Solution {
    public int maxFrequencyElements(int[] nums) {
        int count[] = new int[101];
        for(int i =0;i<nums.length;i++){
            count[nums[i]]++;
        }

        int maxf = 0;
        for(int i = 0;i<count.length;i++){
            if(count[i] > maxf)
                maxf = count[i];
        }

        int sum = 0;

        for(int i = 0;i<count.length;i++){
            if(count[i] == maxf)
            sum += maxf;
        }

        return sum;
    }
}