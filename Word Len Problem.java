public Map<String, Integer> wordLen(String[] strings) {
    Map<String, Integer> map = new HashMap<>();

  for(String key: strings)
    if(!map.containsKey(key))
      map.put(key, key.length());

  return map;
}
