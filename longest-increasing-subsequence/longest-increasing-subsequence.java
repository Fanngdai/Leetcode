class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        
        for(int i: nums) {
            // last element is greater than current and lst does not contain it.
            if(!lst.isEmpty() && lst.get(lst.size() - 1) > i && !lst.contains(i)) {
                // replace next largest value
                lst.set(binarySearch(lst,i,0,lst.size()-1), i);
            } else if(lst.isEmpty() || lst.get(lst.size() - 1) < i) {
                lst.add(i);
            }
        }
        return lst.size();
    }
    
    /*
     * Find the index which is next larger than val
     */
    private int binarySearch(List<Integer> lst, int val, int left, int right) {
        int rtn = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(lst.get(mid)<=val) {
                // go right
                rtn = mid + 1;
                left = mid + 1;
            } else {
                // go left
                rtn = mid;
                right = mid - 1;
            }
        }
        return rtn;
    }
    
}

// [10,9,2,5,3,7,101,18]
// [0,1,0,3,2,3]
// [7,7,7,7,7,7,7]
// [10,9,2,10,11,3,4,5]