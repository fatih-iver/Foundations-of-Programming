public int sumNumbers(String str) {
	int sum = 0;
	
	java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\d+");
	java.util.regex.Matcher matcher = pattern.matcher(str);
	
	while (matcher.find()) {
	  sum += Integer.parseInt(matcher.group());
	}
	s
	return sum;

}