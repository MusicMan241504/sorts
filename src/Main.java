public class Main {

	public static void main(String[] args) {
		double[] array = randArray(200000000,0,1000000);
		//printArray(array);
		//System.out.println("\n\n\n");
		
		long startTime = System.nanoTime();
		
		//bubbleSort(array);
		//insertionSort(array);
		//mergeSort(array,0,array.length-1);
		quickSort(array,0,array.length-1);
		
		long endTime = System.nanoTime();
		long time = endTime-startTime;
		System.out.println(time/1000000.0 + " ms");
				
		//printArray(array);
		System.out.println(isSorted(array));	

	}
	
	public static void printArray(double[] array) {
		for(double item : array) {
			System.out.println(item);
		}
	}
	
	public static boolean isSorted(double[] array) {
		boolean sorted = true;
		for (int i = 0; i < array.length-1; i++) {
			if (array[i] > array[i+1]) {
				sorted = false;
			}
		}
		return sorted;
	}

	public static double[] randArray(int len, int min, int max) {
		double[] array = new double[len];
		for(int i = 0; i < len; i++) {
			array[i] = Math.random()*(max-min)+min;
		}
		return array;
	}

	public static void bubbleSort(double[] array) {
		boolean swaps = true;
		while(swaps) {
			swaps = false;
			for (int i = 0; i < array.length-1; i++) {
				if (array[i] > array[i+1]) {
					double tmp = array[i];
					array[i] = array[i+1];
					array[i+1] = tmp;
					swaps = true;
				}
			}
		}
	}
	
	public static void insertionSort(double[] array) {
		for (int i = 1; i < array.length; i++) {
			double tmp = array[i];
			int i2 = i-1;
			while (i2 >= 0 && tmp < array[i2]) {
				array[i2+1] = array[i2];
				i2 = i2 - 1;
			}
			array[i2+1] = tmp;
			
		}
	}
	
	public static void mergeSort(double[] array, int left, int right) {
		if (left < right) {
			int mid = (left+right)/2;
			mergeSort(array, left, mid);
			mergeSort(array, mid+1, right);
			merge(array, left, mid, right);
		}
	}
	
	public static void merge(double[] array, int left, int mid, int right) {
		//find length of both arrays
		int n1 = mid-left+1;
		int n2 = right-mid;
		//create new arrays
		double array1[] = new double[n1];
		double array2[] = new double[n2];
		//add values to arrays
		for (int i1 = 0; i1 < n1; ++i1) {
			array1[i1] = array[i1+left];
		}
		for (int i2 = 0; i2 < n2; ++i2) {
			array2[i2] = array[i2+mid+1];
		}
		//merge the arrays
		int i1 = 0, i2 = 0;
		int i3 = left;
		while (i1 < n1 && i2 < n2) {
			if (array1[i1] <= array2[i2]) {
				array[i3] = array1[i1];
				i1++;
			}else {
				array[i3] = array2[i2];
				i2++;
			}
			i3++;
		}
		//deal with different lengthed arrays
		while (i1 < n1) {
			array[i3] = array1[i1];
			i1++;
			i3++;
		}
		while (i2 < n2) {
			array[i3] = array2[i2];
			i2++;
			i3++;
		}
	}

	public static void quickSort(double[] array, int left, int right) {
		if (left < right) {
			int pivot = partition(array, left, right);
			quickSort(array, left, pivot - 1);
			quickSort(array, pivot + 1, right);
		}
			
	}
	public static int partition(double[] array, int left, int right) {
		double pivot_value = array[right];
		int i = left - 1; // index of last item in 1st subarray where items < pivot_value
		for (int j = left; j < right; j++) {
			if (array[j] <= pivot_value) {
				i++;
				// swap array[j] and array[i]
				double tmp = array[j];
				array[j] = array[i];
				array[i] = tmp;
			}
		}
		// swap array[i+1] with array[right]
		double tmp = array[i+1];
		array[i+1] = array[right];
		array[right] = tmp;
		
		return i+1;
				
	}
}
