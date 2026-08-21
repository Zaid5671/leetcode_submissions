class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)return false;

        ArrayList<Integer> list = new ArrayList<>();
        int div = 10;
        while(x>0){
            int rem = x%div;
            x -= rem;
            x /= div;
            list.add(rem);
            System.out.println(rem);
        }

        int l =0;
        int r = list.size()-1;

        while(l<r){
            if(list.get(l)!=list.get(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}