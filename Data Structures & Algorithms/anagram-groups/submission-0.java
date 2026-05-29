class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] freq = new int[26];

            for (char ch : str.toCharArray()) {
                ++freq[ch - 'a'];
            }

            map.computeIfAbsent(Arrays.toString(freq), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
