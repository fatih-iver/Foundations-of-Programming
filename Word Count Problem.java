public Map<String, Integer> wordCount(String[] strings) {

  Map<String, Integer> map = new HashMap<>();

  for(String key: strings)

    if(!map.containsKey(key))
      map.put(key, 1);
    else
      map.put(key, map.get(key) + 1);

  return map;

}
