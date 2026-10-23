class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }
        int ans = 0;
        int count  = 0;
        for(int n : set){
            if(!set.contains(n-1)){
                int curr = n;
                count = 1;
                while(set.contains(curr+1)){
                    count++;
                    curr++;
                }
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }
}