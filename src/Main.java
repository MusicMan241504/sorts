package sorts;


public class Main {

	public static void main(String[] args) {
		double[] list = randArray(10000000,0,1000000000);
		//printArray(list);
		//System.out.println("\n\n\n");
		
		long startTime = System.nanoTime();
		
		//bubbleSort(list);
		//insertionSort(list);
		//mergeSort(list,0,list.length-1);
		quickSort(list,0,list.length-1);
		
		long endTime = System.nanoTime();
		long time = endTime-startTime;
		System.out.println(time/1000000.0 + " ms");
				
		//printArray(list);
		System.out.println(isSorted(list));

	}
	
	public static void printArray(double[] list) {
		for(double item : list) {
			System.out.println(item);
		}
	}
	
	public static boolean isSorted(double[] list) {
		boolean sorted = true;
		for (int i = 0; i < list.length-1; i++) {
			if (list[i] > list[i+1]) {
				sorted = false;
			}
		}
		return sorted;
	}

	public static double[] randArray(int len, int min, int max) {
		double[] list = new double[len];
		for(int i = 0; i < len; i++) {
			list[i] = Math.random()*(max-min)+min;
		}
		return list;
	}

	public static void bubbleSort(double[] list) {
		boolean swaps = true;
		while(swaps) {
			swaps = false;
			for (int i = 0; i < list.length-1; i++) {
				if (list[i] > list[i+1]) {
					double tmp = list[i];
					list[i] = list[i+1];
					list[i+1] = tmp;
					swaps = true;
				}
			}
		}
	}
	
	public static void insertionSort(double[] list) {
		for (int i = 1; i < list.length; i++) {
			double tmp = list[i];
			int i2 = i-1;
			while (i2 >= 0 && tmp < list[i2]) {
				list[i2+1] = list[i2];
				i2 = i2 - 1;
			}
			list[i2+1] = tmp;
			
		}
	}
	
	public static void mergeSort(double[] list, int left, int right) {
		if (left < right) {
			int mid = (left+right)/2;
			mergeSort(list, left, mid);
			mergeSort(list, mid+1, right);
			merge(list, left, mid, right);
		}
	}
	
	public static void merge(double[] list, int left, int mid, int right) {
		//find length of both arrays
		int n1 = mid-left+1;
		int n2 = right-mid;
		//create new arrays
		double array1[] = new double[n1];
		double array2[] = new double[n2];
		//add values to arrays
		for (int i1 = 0; i1 < n1; ++i1) {
			array1[i1] = list[i1+left];
		}
		for (int i2 = 0; i2 < n2; ++i2) {
			array2[i2] = list[i2+mid+1];
		}
		//merge the arrays
		int i1 = 0, i2 = 0;
		int i3 = left;
		while (i1 < n1 && i2 < n2) {
			if (array1[i1] <= array2[i2]) {
				list[i3] = array1[i1];
				i1++;
			}else {
				list[i3] = array2[i2];
				i2++;
			}
			i3++;
		}
		//deal with different lengthed arrays
		while (i1 < n1) {
			list[i3] = array1[i1];
			i1++;
			i3++;
		}
		while (i2 < n2) {
			list[i3] = array2[i2];
			i2++;
			i3++;
		}
	}

	public static void quickSort(double[] list, int left, int right) {
		//if left < right:
			
	}
}
