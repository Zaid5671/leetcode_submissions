class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for(int i : nums){
            set.add(i);
        }
        int mulK = k;
        while(set.contains(mulK)){
            mulK += k;
        }

        return mulK;
    }
}