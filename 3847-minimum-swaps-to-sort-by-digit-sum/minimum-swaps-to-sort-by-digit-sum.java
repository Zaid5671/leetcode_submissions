class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] dS = new int[n];

        for(int i = 0;i<n;i++){
            int curr = nums[i];
            int sum = 0;
            while(curr != 0){
                sum += curr%10;
                curr /= 10;
            }
            dS[i] = sum;
            // System.out.println(sum);
        }

        // dS = [9,9,9,7]

        int[][] pairs = new int[n][2];// stoes val and orgIdx

        for(int i = 0;i<n;i++){
            pairs[i][0] = dS[i];
            pairs[i][1] = i;
        }

        // pairs = [[9,1],[9,2],[9,3],[7,4]]

        // sort pairs

        Arrays.sort(pairs,(a,b)->{
            // System.out.println(a[0] + " " + b[0]);
            if(a[0]==b[0]){
                return nums[a[1]]-nums[b[1]]; // diff of org vals
            }
            return a[0]-b[0];
        });

        int swaps = 0;

        boolean[] vis = new boolean[n];

        for(int i =0;i<n;i++){
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
                swaps += cycles-1;
            }
        } 

        return swaps;
    }
}