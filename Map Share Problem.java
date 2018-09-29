public Map<String, String> mapShare(Map<String, String> map) {

    String keyA = "a";
    String keyB = "b";
    String keyC = "c";

    String valueA = map.get(keyA);

    if(valueA != null) { map.put(keyB, valueA); }

    if(map.containsKey(keyC)){ map.remove(keyC); }

    return map;
  }
