class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int nums1Len = nums1.length, nums2Len = nums2.length;
        
        PriorityQueue<SumVal> queue = new PriorityQueue<>(10, new Comparator<SumVal>() {
            public int compare(SumVal v1, SumVal v2) {
                return v1.sum - v2.sum;
            }
        });
        
        for(int i=0; i<k && i < nums1Len; i++) {
            for(int j=0; j<k && j < nums2Len; j++) {
                List<Integer> lst = new ArrayList<>();
                lst.add(nums1[i]);
                lst.add(nums2[j]);
                SumVal sumVal = new SumVal(nums1[i] + nums2[j], lst);
                queue.add(sumVal);
            }
        }
        
        List<List<Integer>> rtn = new ArrayList<>();
        
        for(int i=0; i<k && !queue.isEmpty(); i++) {
            rtn.add(queue.poll().lst);
        }
        
        return rtn;
    }
}

class SumVal {
    int sum;
    List<Integer> lst;
    
    public SumVal(int sum, List<Integer> lst) {
        this.sum = sum;
        this.lst = lst;
    }
}