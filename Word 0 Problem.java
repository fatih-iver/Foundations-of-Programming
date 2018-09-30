public Map<String, Integer> word0(String[] strings) {

  Map<String, Integer> map = new HashMap<>();

  for(String key: strings)
    if(!map.containsKey(key))
      map.put(key, 0);

  return map;

}
