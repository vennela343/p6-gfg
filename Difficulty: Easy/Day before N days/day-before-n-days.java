// User function Template for Java
class Solution {
    public static int nthDay(int d, int n) {
        // write your code here
        int ans=d-n;
        while(ans<0){
            ans=ans+7;
            if(ans>=0){
                return ans;
            }
        }
        return ans;
    }
}