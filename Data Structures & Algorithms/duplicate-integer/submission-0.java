class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = HashSet.newHashSet(nums.length);

        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }
}