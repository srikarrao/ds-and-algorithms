package com.sorting.algorthim;

import java.util.Scanner;

/**
 * 
 * @author SrikarRao Desc: Program to implement Merge Sort
 */

public class MergeSort {

	// Declaring the arrays
	private int[] A;
	private int[] LR;

	// Declaring length of the arrays
	private int length;

	/**
	 * Main method to execute the sort, merge methods
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// declare an input array
		int[] aMain;
		// creating a reference and assigning it to an object
		MergeSort mergeSort = new MergeSort();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of the array A: ");
		int size = input.nextInt();
		System.out.println();

		// initialize the size of array aMain[]
		aMain = new int[size];
		System.out.println("Please enter " + aMain.length + " values: ");
		// assigning the user input values for the input array
		for (int index = 0; index < aMain.length; index++) {
			aMain[index] = input.nextInt();
		}

		// invoking the implementSorting method
		mergeSort.implementSorting(aMain);
	}

	/**
	 * @param aMain
	 *            [] method to initialize the arrays and invoke the sortArray()
	 *            method
	 */
	public void implementSorting(int[] aMain) {
		this.A = aMain;
		length = aMain.length;

		// initialize array LR[]
		this.LR = new int[length];

		System.out.println(" After Sorting and size " + length);
		// invoking sortArray()
		sortArray(0, length - 1);

		// Displays the sorted array
		for (int x = 0; x < A.length; x++) {
			System.out.print(A[x] + "  ");
		}
	}

	/**
	 * Method to implement sorting of the array
	 * 
	 * @param low
	 * @param high
	 */
	private void sortArray(int low, int high) {
		// if condition to check low < high
		if (low < high) {
			// finding the mid element of the array
			int mid = low + (high - low) / 2;
			// invoking sortArray() passing low,high
			sortArray(low, mid);
			// invoking sortArray() passing mid+1,high
			sortArray(mid + 1, high);
			// invoking mergeArray()
			mergeArray(low, mid, high);
		}
	}

	/**
	 * Method to implement merging of the sorted array
	 * 
	 * @param low
	 * @param mid
	 * @param high
	 */
	private void mergeArray(int low, int mid, int high) {

		// for loop to initialize values to LR[]
		for (int i = low; i <= high; i++) {
			LR[i] = A[i];
		}

		int i = low;
		int j = mid + 1;
		int k = low;

		// while loop implementing the sorting
		while (i <= mid && j <= high) {
			if (LR[i] <= LR[j]) {
				A[k] = LR[i];
				i++;
			} else {
				A[k] = LR[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			A[k] = LR[i];
			k++;
			i++;
		}
	}
}