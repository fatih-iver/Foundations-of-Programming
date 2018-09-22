public int maxSpan(int[] nums) {
	  
  Map<Integer, ArrayList<Integer>> dict = new HashMap<Integer, ArrayList<Integer>>();
  
  for(int index = 0; index < nums.length; index++) {
	ArrayList<Integer> value = dict.get(nums[index]);
	if (value != null) {
		value.add(index);
	} else {
	  value = new ArrayList<Integer>();
	  value.add(index);
	  dict.put(nums[index], value);
	}
  }
  
  int maxSpan = 0;
  for (Map.Entry<Integer, ArrayList<Integer>> entry : dict.entrySet()) {
	ArrayList<Integer> value = entry.getValue();
 
	int firstIndex = value.get(0);
	int lastIndex = value.get(value.size() - 1);
	int currSpan = lastIndex - firstIndex + 1;

	if (currSpan > maxSpan){ maxSpan = currSpan; }
	
  }
  
  return maxSpan;
}