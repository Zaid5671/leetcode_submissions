class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();

        int l = 0;
        int r = arr.length - k;
        //The reason we do not compare mid to mid + k - 1 is because we are not trying to evaluate the current window itself. We are trying to decide: Should we slide this window to the right
        //If you compare arr[mid] to arr[mid + k - 1], you are just comparing the left end of your current window to the right end of your current window.
        //Knowing which end of your current window is closer to x does not tell you anything about what lies outside the window. 
        //You could have a perfect match sitting at mid + k, but you would never see it because you only looked at the elements already inside your boundaries.
        while (l < r) {
            int mid = l + (r - l) / 2;
            // i still didn't understood this maths trick
            if (x - arr[mid] > arr[mid + k] - x) {
                l = mid + 1;//cause you know for sure mid is not the ans
            } else {
                r = mid;// cause u can't say if mid is the ans or not
            }
        }

        // create array
        //A while loop only breaks when `l` is equal to `r`. 
        //Hence you could use any of them for the loop. 
        //Also hence, you do not use `mid` but you use `L` or `R` because, from the whole of the array, you took that one index. You shrunk the space like that so that you could have that one index, which could be the perfect starting index. `mid` is something that is always changing; that is just a guess. I know that in general the answer is `mid`, but not here. That is only when you have to find something. Here you are shrinking the search space to exactly one element and that element is equal to `L = R`. 
        for (int i = l; i <= l + k - 1; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}