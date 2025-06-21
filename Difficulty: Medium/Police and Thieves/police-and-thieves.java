class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        int n = arr.length;
        List<Integer> police = new ArrayList<>();
        List<Integer> thieves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else if (arr[i] == 'T') {
                thieves.add(i);
            }
        }

        int p = 0, t = 0, count = 0;
        while (p < police.size() && t < thieves.size()) {
            if (Math.abs(police.get(p) - thieves.get(t)) <= k) {
                count++;
                p++;
                t++;
            } else if (police.get(p) < thieves.get(t)) {
                p++;
            } else {
                t++;
            }
        }

        return count;
    }
}

        
  