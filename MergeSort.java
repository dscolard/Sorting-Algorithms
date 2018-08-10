import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Divide and Conquer algorithm.
 * Recursively breaks data into smallest individual piece.
 * Then Merges pieces back together in desired order.
*/

public class MergeSort {
	
	/*Array to store data from file*/
	static double[] data = new double[100];
	
	/*Reads in file containing doubles and constructs an array from them*/
	public static double[] constructArray(double[] data, File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		int i = 0;
		while (scanner.hasNextDouble()) {
			double s = scanner.nextDouble();
			data[i] = s;
			i++;
		}
		return data;
	}

	/*Recursive method breaks down problem into manageable chunks and calls sort()*/
	static void sort(double data[], int left, int right) {
		
		if(left<right) {
			int middle = (left+right)/2;
			sort(data, left, middle);
			sort(data, middle+1, right);
			
			mergeHalves(data, left, middle, right);
		}

	}
	
	/*Merges two arrays of type double in ascending order*/
	static void mergeHalves(double data[], int left, int middle, int right) {
		int size1 = middle - left + 1;
		int size2 = right - middle;
		
		double[] leftArray = new double[size1];
		double[] rightArray = new double[size2];
		
		for(int i=0; i<leftArray.length; ++i) {
			leftArray[i] = data[left+i];
		}
		for(int j=0; j<rightArray.length; ++j) {
			rightArray[j] = data[middle+1+j];
		}
		
		int i=0, j=0;
		int k=left;
		while(i<size1 && j<size2) {
			if(leftArray[i] <= rightArray[j]) {
				data[k] = leftArray[i];
				i++;
			}
			else {
				data[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
		while(i < size1) {
			data[k] = leftArray[i];
			i++; 
			k++;
		}
		
		while(j < size2) {
			data[k] = rightArray[j];
			j++; 
			k++;
		}	

	}
	
	/*Runs the algorithm and prints results*/
	static void testAlgorithm() throws FileNotFoundException {
		data = constructArray(data, new File("numbers100.txt"));
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
