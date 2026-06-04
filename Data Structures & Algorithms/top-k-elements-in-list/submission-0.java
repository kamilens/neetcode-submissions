class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            frequencies.merge(num, 1, Integer::sum);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> freq : frequencies.entrySet()) {
            int num = freq.getKey();
            int f = freq.getValue();

            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(num);
        }

        int[] result = new int[k];
        int resultP = 0;

        for (int i = buckets.length - 1; i >= 0 && resultP < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[resultP++] = num;
                    if (resultP == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
