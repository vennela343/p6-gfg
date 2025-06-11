
    
    class Solution {
    public int findLength(int[] color, int[] radius) {
        // code here
        int n=color.length,balls=n;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(!st.isEmpty() && color[st.peek()]==color[i] && radius[st.peek()]==radius[i]){
                st.pop();
                balls-=2;
            }
            else st.push(i);
        }
        return balls;
    }
}

    
