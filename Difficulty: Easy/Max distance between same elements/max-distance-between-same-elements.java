class Solution {
    public int maxDistance(int[] arr) {
        // Code here
        HashMap<Integer,Integer> mp=new HashMap<>();
        int res=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(!mp.containsKey(arr[i])){
                mp.put(arr[i], i);
            }else{
                int dist=i-mp.get(arr[i]);
                res=Math.max(res,dist);
            }
        }
        return res;
    }
}