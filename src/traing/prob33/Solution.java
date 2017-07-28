package traing.prob33;

/**
 * Search in Rotated Sorted Array
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array/tabs/description
 *
 * @author zhaokai
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        final int n = nums.length;
        int start = 0, end = n - 1;
        while (start < end) {
            int middle = (start + end) / 2;
            if (nums[middle] > nums[end]) start = middle + 1;
            else end = middle;
        }

        int pivot = start;
        start = 0; end = n - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            int realMiddle = (middle + pivot) % n;
            if (target == nums[realMiddle]) return realMiddle;
            if (target > nums[realMiddle]) start = middle + 1;
            else end = middle - 1;
        }
        return -1;
    }

//    int search(int A[], int n, int target) {
//        int lo=0,hi=n-1;
//        // find the index of the smallest value using binary search.
//        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
//        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
//        while(lo<hi){
//            int mid=(lo+hi)/2;
//            if(A[mid]>A[hi]) lo=mid+1;
//            else hi=mid;
//        }
//        // lo==hi is the index of the smallest value and also the number of places rotated.
//        int rot=lo;
//        lo=0;hi=n-1;
//        // The usual binary search and accounting for rotation.
//        while(lo<=hi){
//            int mid=(lo+hi)/2;
//            int realmid=(mid+rot)%n;
//            if(A[realmid]==target)return realmid;
//            if(A[realmid]<target)lo=mid+1;
//            else hi=mid-1;
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        final Solution s = new Solution();

        System.out.println(s.search(new int[] {1, -1, 0}, 0));
        System.out.println(s.search(new int[] {1, 3}, 2));
        System.out.println(s.search(new int[] {1, 3}, 1));
        System.out.println(s.search(new int[] {3, 1}, 1));
        System.out.println(s.search(new int[] {3, 1}, 3));
        System.out.println(s.search(new int[] {3, 1}, 0));
//        System.out.println(s.search(new int[] {3, 1}, 2, 1));
    }
}
