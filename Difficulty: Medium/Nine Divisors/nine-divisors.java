class Solution {
    public static int countNumbers(int n) {
        // code here
        int limit = (int) Math.sqrt(n);
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        int count = 0;
        
        for (int p : primes) {
            long p8 = 1;
            for (int i = 0; i < 8; i++) {
                if (p8 > n / p) { 
                    p8 = Long.MAX_VALUE;
                    break;
                }
                p8 *= p;
            }
            if (p8 <= n) {
                count++;
            } else {
                break; 
            }
        }
        
        for (int i = 0; i < primes.size(); i++) {
            int p = primes.get(i);
            long p2 = (long) p * p;
            if (p2 * p2 > n) break; 
            
            for (int j = i + 1; j < primes.size(); j++) {
                int q = primes.get(j);
                long q2 = (long) q * q;
                if (p2 * q2 > n) break;
                count++;
            }
        }
        
        return count;
    }
}