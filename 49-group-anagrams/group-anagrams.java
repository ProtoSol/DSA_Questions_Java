public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] strArray = str.toCharArray();

            Arrays.sort(strArray);

            String sorted = new String(strArray);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());

            }
            map.get(sorted).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }
}