class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int res=0;
        int n=arr.length;
        if(n<k)
        return 0;
        
        int sum=0;
        for(int i=0;i<k;i++)
        {
           sum+=arr[i]; 
        }
        res=sum;
        for(int i=k;i<n;i++)
        {
            sum=sum+(arr[i]-arr[i-k]);
            res=Math.max(sum,res);
        }
        return res;
    }
}