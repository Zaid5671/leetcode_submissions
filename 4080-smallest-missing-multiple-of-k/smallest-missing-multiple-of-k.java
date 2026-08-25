class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int mulK = k;
        for(int i : nums){
            set.add(i);
            if(set.contains(mulK)){
                mulK += k;
            }
        }
        
        while(set.contains(mulK)){
            mulK += k;
        }

        return mulK;
    }
}