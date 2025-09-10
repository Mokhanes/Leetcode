class Solution {
    public int[] searchRange(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        int res[] = {-1,-1};

        while(s<=e){
            if(nums[s]==target){
                res[0] = s;
                while(s<nums.length && nums[s]==target ){
                    s++;
                }
                res[1] = --s;
                break;
            }
            else{
                s++;
            }

            if(nums[e]==target){
                res[1] = e;
                while(e>=0 && nums[e]==target){
                    e--;
                }
                res[0] = ++e;
                break;
            }else{
                e--;
            }

            
        }
        
        return res;
    }
}