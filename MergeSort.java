class MergeSort {
	static void mergeSort(int[] array) {
		if(array.length == 0) return;
		int[] temp = new int[array.length];
		MergeSort.mergeSort(array, temp, 0, array.length-1);
	}

	static void mergeSort(int[] array, int[] temp, int low, int high) {
		//Until parts are of size 1 element
		//if(low < high) {
		if(low != high) {
			int center = (low+high)/2;
			MergeSort.mergeSort(array, temp, low, center);
			MergeSort.mergeSort(array, temp, center+1, high);
			MergeSort.merge(array, temp, low, center, high);
		}
	}

	static void merge(int[] array, int[] temp, int low, int center, int high) {
		int lowIndex = low;
		int tempIndex = low;
		int highIndex = center+1;
		while(lowIndex <= center && highIndex <= high) {
			if(array[lowIndex] < array[highIndex]) {
				temp[tempIndex++] = array[lowIndex++];
			}
			else {
				temp[tempIndex++] = array[highIndex++];
			}
		}

		while(tempIndex <= high) {
			if(lowIndex <= center) {
				temp[tempIndex++] = array[lowIndex++];
			}
			else if(highIndex <= high){
				temp[tempIndex++] = array[highIndex++];
			}
		}

		tempIndex = low;
		while(tempIndex <= high) {
			array[tempIndex] = temp[tempIndex++];
		}
	}
}