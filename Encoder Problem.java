public String[] encoder(String[] raw, String[] code_words) {

  String[] encoded = new String[raw.length];

  Map<String, String> map = new HashMap<>();

  int counter = 0;
  int index = 0;

  for(String key: raw) {
    if(!map.containsKey(key))
      map.put(key, code_words[counter++]);
    encoded[index++] = map.get(key);
  }

  return encoded;

}
