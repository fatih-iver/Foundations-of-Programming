public Map<String, String> pairs(String[] strings) {
      Map<String, String> map = new HashMap<>();

  for(String key: strings) {
    char firstChar = key.charAt(0);
    char lastChar = key.charAt(key.length() - 1);
    map.put(Character.toString(firstChar), Character.toString(lastChar));
  }

  return map;
}
