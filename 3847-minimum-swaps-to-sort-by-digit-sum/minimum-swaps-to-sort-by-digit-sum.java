class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] dS = new int[n];

        for(int i = 0;i<n;i++){
            int sum = 0;
            int curr = nums[i];
            while(curr != 0){
                sum += curr%10;
                curr /= 10;
            }
            dS[i] = sum;
            // System.out.println(dS[i]);
        }

        int[][] pairs = new int[n][2];

        for(int i = 0;i<n;i++){
            pairs[i][0] = dS[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a,b)->{
            if(a[0]==b[0]){
                //cmp by orginal values in nums 
                return nums[a[1]]-nums[b[1]];
            }
            return a[0]-b[0];
        });

        // for(int i = 0;i<n;i++){
        //     System.out.println(pairs[i][0] + " " + pairs[i][1]);
        // }
        boolean[] vis = new boolean[n];

        int swap = 0;

        for(int i = 0;i<n;i++){
            int orgIdx = pairs[i][1];

            if(vis[i] || orgIdx == i){
                continue;
            }

            int cycles = 0;
            int j = i;

            while(!vis[j]){
                vis[j] = true;
                j = pairs[j][1];
                cycles++;
            }
            if(cycles>0){
                swap += cycles-1;
            }
        }
        return swap;   
    }
}