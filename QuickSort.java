import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickSort {
	
	static double[] data = new double[100];
	
	/*Reads in file containing doubles and constructs an array from them*/
	public static double[] constructarray(double[] data, File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		int i = 0;
		while (scanner.hasNextDouble()) {
			double s = scanner.nextDouble();
			data[i] = s;
			i++;
		}
		return data;
	}
	
	/*Recursively calls partition*/
	static void sort(double data[], int start, int end) {
		if (start < end) {
			int pIndex = partition(data, start, end);
			sort(data, start, pIndex - 1);
			sort(data, pIndex + 1, end);
		}
	}

	/*Partitions the array around the right most element*/
	static int partition(double data[], int start, int end) {
		double pivot = data[end];
		int pIndex = start;
		for (int i = start; i < end; i++) {
			if (data[i] <= pivot) {
				swap(data, i, pIndex);
				pIndex++;
			}
		}
		swap(data, pIndex, end);
		return pIndex;
	}
	
	/*Swaps array elements at positions x and y*/
	static void swap(double data[], int x, int y) {
		double temp = data[x];
		data[x] = data[y];
		data[y] = temp;
	}
	
	/*Runs the algorithm*/
	static void testAlgorithm() throws FileNotFoundException {
		data = constructarray(data, new File("numbers100.txt"));
		printData();
		sort(data, 0, data.length-1);
		System.out.println();
		printData();
	}
	
	/*Prints data array*/
	static void printData() {
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]+" ");
		}
	}
	
	public static void main(String args[]) throws FileNotFoundException {
		testAlgorithm();
	}
}
