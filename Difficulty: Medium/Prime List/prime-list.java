//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/


class Solution {
    List<Integer> primes;

    public Solution() {
        primes = generatePrimes(20000); 
    }

    Node primeList(Node head) {
        Node curr = head;
        while (curr != null) {
            curr.val = nearestPrime(curr.val);
            curr = curr.next;
        }
        return head;
    }
    private List<Integer> generatePrimes(int limit) {
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

        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) primeList.add(i);
        }
        return primeList;
    }
    private int nearestPrime(int n) {
        int left = 0, right = primes.size() - 1;
        int closest = primes.get(0);

        while (left <= right) {
            int mid = (left + right) / 2;
            int prime = primes.get(mid);

            if (prime == n) return prime;

            if (Math.abs(prime - n) < Math.abs(closest - n) ||
                (Math.abs(prime - n) == Math.abs(closest - n) && prime < closest)) {
                closest = prime;
            }

            if (prime < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return closest;
    }
}

        
    
