class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        int total = arr.length/3,i=0, count=1;
        while(i<arr.length) {
            if(i==arr.length-1) {
                if(count>total)
                    list.add(arr[i]);
            }
            else {
                if(arr[i]==arr[i+1])
                    count++;
                else {
                    if(count>total)
                        list.add(arr[i]);
                    count=1;
                }
            }
            i++;
        }
        return list;
    }
}
   