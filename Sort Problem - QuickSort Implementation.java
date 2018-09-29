public static int[] quicksort(int[] arr) {

		int length = arr.length;

		if(length <= 1) {
			return arr;
		}

		int pivot = arr[0];

		int countSmaller = 0;
		int countBigger = 0;

		for(int val: arr) {
			if (pivot > val)
				countSmaller++;
			else if (pivot < val)
				countBigger++;
		}

		int[] biggerOnes = new int[countBigger];
		int[] smallerOnes = new int[countSmaller];

		int counterSmallers = 0;
		int counterBiggers = 0;

		for(int val: arr) {
			if (pivot > val)
				smallerOnes[counterSmallers++] = val;
			else if (pivot < val)
				biggerOnes[counterBiggers++] = val;
		}

		int[] sortedSmallerOnes = quicksort(smallerOnes);
		int[] sortedBiggerOnes = quicksort(biggerOnes);

		int sortedSLength = sortedSmallerOnes.length;
		int sortedBLength = sortedBiggerOnes.length;

		int[] sorted = new int[sortedSLength + sortedBLength + 1];

		int sortedCounter = 0;

		for(int val: sortedSmallerOnes)
			sorted[sortedCounter++] = val;

		sorted[sortedCounter++] = pivot;

		for(int val: sortedBiggerOnes)
			sorted[sortedCounter++] = val;

		return sorted;
	}
