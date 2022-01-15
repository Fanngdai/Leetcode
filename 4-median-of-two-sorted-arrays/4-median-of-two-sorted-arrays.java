class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        
        if(len1 == 0 && len2 == 0) {
            return 0;
        }
        
        int mid = (len1+len2)/2, counter1 = 0, counter2 = 0, temp = 0;
        boolean even = (len1+len2)%2 == 0;
        
        while(counter1 < len1 || counter2 < len2) {
            // reached mid and is even
            if(counter1 + counter2 == mid-1 && even) {
                if(counter1 < len1 && counter2 < len2) {
                    temp = Math.min(nums1[counter1], nums2[counter2]);
                } else if(counter1 < len1) {
                    return (double)(nums1[counter1] + nums1[counter1+1])/2;
                } else {
                    return (double)(nums2[counter2] + nums2[counter2+1])/2;
                }
            } else if(counter1 + counter2 == mid){
                // is odd
                if(counter1 < len1 && counter2 < len2) {
                    temp = temp + Math.min(nums1[counter1], nums2[counter2]);
                } else if(counter1 < len1) {
                    temp = temp + nums1[counter1];
                } else {
                    temp = temp + nums2[counter2];
                }
                return even ? (double)temp/2 : temp;
            }
            
            // look for min in both array
            if(counter1 < len1 && counter2 < len2) {
                if(nums1[counter1] < nums2[counter2]) {
                    counter1++;
                } else {
                    counter2++;
                }
            } else if(counter1 < len1) {
                counter1++;
            } else if(counter2 < len2) {
                counter2++;
            }
        }
        
        return -1;
    }
}

/*
[2]
[]
*/