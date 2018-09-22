public String stringSplosion(String str) {
  String generatedStr = "";
  for(int i = 1; i <= str.length(); i++){
    generatedStr += str.substring(0, i);
  }
  
  return generatedStr;
}
