class Solution {
    public int countPrimes(int n) {
        if(n < 3)
            return 0;
        
        boolean[] primes = new boolean[n];
        init(primes);
        int p = 2;
        
        while(p < Math.sqrt(n)) {
            crossOff(primes, p);
            p = findNext(primes, p);
            if(p == -1) break;
        }
        
        return findPrimes(primes);
    }
    
    private void init(boolean[] primes) {
        primes[0] = false;
        primes[1] = false;
        for(int i=2; i<primes.length; i++) {
            primes[i] = true;
        }
    }
    
    private void crossOff(boolean[] primes, int p) {
        for(int i = p * p; i < primes.length; i+=p) {
            primes[i] = false;
        }
    }
    
    private int findNext(boolean[] primes, int p) {
        for(int i = p+1%2==0 ? p+2 : p+1; i < primes.length; i++) {
            if(primes[i]) {
                return i;
            }
        }
        return -1;
    }
    
    private int findPrimes(boolean[] primes) {
        int count = 0;
        for(int i=2; i < primes.length; i++) {
            if(primes[i])
                count++;
        }
        return count;
    }
    
    /*
     * Testing purpose
     */
    private void printPrimes(boolean[] primes) {
        for(int i=2; i < primes.length; i++) {
            System.out.println(i + "\t" + primes[i]);
        }
    }
}

/*
 * Sieve of Erathosthenes
 */