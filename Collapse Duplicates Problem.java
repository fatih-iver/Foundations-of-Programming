public String collapseDuplicates(String a) {
  int i = 0;
  String result = "";

  while(i < a.length()) {

    char ch = a.charAt(i);
    result += ch;

    while(i < a.length() - 1 && a.charAt(i+1) == ch) {
      i++;
    }

    i++;

  }

  return result;
}
