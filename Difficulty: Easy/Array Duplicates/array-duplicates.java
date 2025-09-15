class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        Arrays.sort(arr);
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                a.add(arr[i]);
            }
          
        }
          return a;
    }
}