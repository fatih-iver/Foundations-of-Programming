public boolean canBalance(int[] nums) {

      int sum = 0;

      for(int num: nums) { sum += num;}

      if(sum % 2 != 0){ return false;}

      int halfSum = sum / 2;

      int splitSum = 0;

      int index = 0;

      while(splitSum < halfSum) {
        splitSum += nums[index];
        index++;
      }

      return splitSum == halfSum;

}
