public static String withoutStringRecursion(String base, String remove) {
	
	int removeLength = remove.length();
	
	if(base.length() < remove.length()) {
		return base;
	}
	
	String subString = base.substring(0, removeLength);
	
	if (subString.equalsIgnoreCase(remove)) {
		return withoutStringRecursion( base.substring(remove.length()),remove);
	} else {
		return base.charAt(0) + withoutStringRecursion(base.substring(1), remove);
	}
	
}