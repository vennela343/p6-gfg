class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here
        int n=arr.length;
       int[] ans=new int[n];
        int extra=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%k!=0){
                ans[i]=k-arr[i]%k;
            }
            else{
                count++;
                ans[i]=0;
            }
            
            
            
        }
        
        if(count>=n+1/2)return 0;
        else{
            Arrays.sort(ans);
            for(int i=0;i<=(ans.length);i++){
                if(count>=(n+1)/2)break;
                if(ans[i]!=0){
                    extra+=ans[i];
                    count++;
                
                
            }
        }}
        return extra;
    }
}
   