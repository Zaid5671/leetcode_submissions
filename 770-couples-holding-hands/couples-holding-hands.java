class Solution {
    public int minSwapsCouples(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0 ;i<n;i++){
            map.put(nums[i],i);
        }
        int swap = 0;
        for(int i =0;i<n-1;i+=2){
            int per1 = nums[i];

            int target = per1^1;
            int actual = nums[i+1];

            if(target == actual){
                continue;
            }

            int targetIdx = map.get(target);
            //swap target with actual
            nums[i+1] = target;
            nums[targetIdx] = actual;
            map.put(target,i+1);
            map.put(actual,targetIdx);
            swap++;
        }
        return swap;
    }
}