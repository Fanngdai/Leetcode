/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return firstBadVersion(1, n);
    }
    
    private int firstBadVersion(int left, int right) {
        while(left < right) {
            int mid = left + (right - left) / 2;
            // this is bad, so move left
            if(isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}

// 3
// 2
// 2126753390
// 1702766719