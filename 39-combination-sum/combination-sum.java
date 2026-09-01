class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backTrack(0,candidates,ans,list,target);
        return ans;
    }

    public void backTrack(int i,int[] nums, List<List<Integer>> ans,  List<Integer> list,int sum){
        if(sum==0){
            ans.add(new ArrayList<>(list));
            return;
        }
            
        if(sum<0){
            return;
        }
        if(i>=nums.length)return;
        list.add(nums[i]);
        backTrack(i,nums,ans,list,sum-nums[i]);

        list.remove(list.size()-1);
        backTrack(i+1,nums,ans,list,sum);
        
    }
}