class Solution {
    public int countDigits(int n) {
        // code here
        String a=String.valueOf(n);
        int count=0;
        for(int i=1;i<=a.length();i++){
            count+=1;
        }
        return count;
    }
}
