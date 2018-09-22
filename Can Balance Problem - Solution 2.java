public boolean canBalance(int[] nums) {

	if(nums.length < 2) { return false; }

	int beginIndex = 0;
	int endIndex = nums.length - 1;

	int rightSum = 0;
	int leftSum = 0;

	while(beginIndex <= endIndex) {

		if(rightSum >= leftSum)
			leftSum += nums[endIndex--];
		else
			rightSum += nums[beginIndex++];

	}

	return rightSum == leftSum;

}
