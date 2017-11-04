package me.stormma.leetcode.array;

public class Question4 {

    private int search(int[] nums1, int k, int[] nums2) {
        int low = 0, high = nums1.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums1[mid - 1] <= nums2[k - mid] && nums2[k - mid - 1] <= nums1[mid]) {
                return Math.max(nums1[mid - 1], nums2[k - mid - 1]);
            }
            if (nums1[mid - 1] > nums2[k - mid]) {
                high = mid - 1;
            } else if (nums2[k - mid - 1] > nums1[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 7};
        int[] nums2 = {2, 5, 6};
        System.out.println(new Question4().search(nums1, 3, nums2));
    }
}

// 1 2 2 3 3 3 4 5 5 8 9

// [1, 2, 3, 3, 4, 5] ==> nums1
// [2, 3, 5, 8, 9] ==> nums2

// k = 5
// mid = 5 / 2 => 2 ==> [2] = 3    2
// k - mid = 3 => [3] = 8
// if nums1[mid - 1] <= nums2[k - mid] and nums[k - mid - 1] <= nums1[mid] :
            //return Math.max(nums1[mid - 1], nums2[k - mid - 1])


//

