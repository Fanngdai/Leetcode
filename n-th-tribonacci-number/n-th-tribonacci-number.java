class Solution {
    List<Integer> lst = new ArrayList<>();
    
    public int tribonacci(int n) {
        lst.add(0);
        lst.add(1);
        lst.add(1);
        return tribonacciHelper(n);
    }
    
    private int tribonacciHelper(int n) {
        if(lst.size() > n && lst.get(n) != null) {
            return lst.get(n);
        }
        lst.add(n, tribonacciHelper(n-1) + tribonacciHelper(n-2) + tribonacciHelper(n-3));
        return lst.get(n);
    }
}