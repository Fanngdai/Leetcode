class RLEIterator {
    private int[] encoding;
    private int CAPACITY;
    private int index;

    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        this.index = 0;
        this.CAPACITY = encoding.length;
    }
    
    public int next(int n) {
        if(index >= CAPACITY) {
            return -1;
        } else if(n==0) {
            return encoding[index+1];
        }

        int temp = encoding[index];
        encoding[index] -= n;

        if(encoding[index] < 0) {
            this.index+=2;
            return next(n-temp);
        } else {
            return encoding[index+1];
        }
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */