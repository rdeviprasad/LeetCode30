class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String key = new String(s);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        List<List<String>> returnList = new ArrayList<>();
        for(List<String> value: map.values()) {
            returnList.add(value);
        }
        return returnList;
    }
}