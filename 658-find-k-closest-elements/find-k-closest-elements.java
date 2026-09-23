class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int sumOfD = 0;
        int prevSum = 0;
        int startIdx = 0;
        int n = arr.length;
        List<Integer> list = new ArrayList<>();

        for(int i = 0;i<k;i++){
            sumOfD += Math.abs(x-arr[i]);
        }
        
        for(int r = k;r<n;r++){
            prevSum = sumOfD;
            sumOfD -= Math.abs(x-arr[r-k]);
            sumOfD += Math.abs(x-arr[r]);
            System.out.println(sumOfD);
            if(sumOfD>prevSum){
                break;
            }
            else if(sumOfD<prevSum){
                startIdx = r-k+1;
            }
        }
        // if()
        // create array
        for(int i = startIdx;i<startIdx+k;i++){
            list.add(arr[i]);
        }
        return list;
    }
}