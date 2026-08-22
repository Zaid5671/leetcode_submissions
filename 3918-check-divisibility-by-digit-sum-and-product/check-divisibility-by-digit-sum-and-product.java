class Solution {
    public boolean checkDivisibility(int n) {
        int digitSum = 0;
        int digitProd = 1;
        int n1 = n;
        while(n1>0){
            int digit = n1%10;
            digitSum += digit;
            digitProd *= digit;
            n1 /= 10;
            // System.out.println(digit);
            // System.out.println(digitSum + " " + digitProd);
        }

        return n%(digitSum+digitProd) == 0;
    }
}