package com.sorting.algorthim;

import java.util.Scanner;

/**
 * 
 * @author SrikarRao :: Java Program to Implement Heap Sort
 */

public class HeapSort {
	private static int N;

	/* Main method */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Heap Sort Test\n");
		int n;

		/* Accept number of elements */
		System.out.println("Enter number of integer elements");
		n = scan.nextInt();

		/* Make array of n elements */
		int arrMain[] = new int[n];

		/* Accept elements */
		System.out.println("\nEnter " + n + " integer elements");
		for (int i = 0; i < n; i++)
			arrMain[i] = scan.nextInt();

		/* Call method sort */
		sort(arrMain);

		/* Print sorted Array */
		System.out.println("\nElements after sorting ");
		for (int j = 0; j < n; j++) {
			System.out.print(arrMain[j] + " ");
		}
		System.out.println();
	}

	/* Sort Function */
	public static void sort(int arrX[]) {

		/** Find the largest number and place it in the first place of the array **/
		heapify(arrX);

		for (int i = N; i > 0; i--) {
			/** swaps the first element with the ith element **/
			swap(arrX, 0, i);
			N = N - 1;
			maxheap(arrX, 0);
		}
	}

	/* Function to build a heap */
	public static void heapify(int arrY[]) {
		N = arrY.length - 1;
		for (int i = N / 2; i >= 0; i--) {
			maxheap(arrY, i);
		}
	}

	/* Function to swap largest element in heap */
	public static void maxheap(int arrZ[], int i) {

		int left = 2 * i;
		int right = 2 * i + 1;
		int max = i;

		if (left <= N && arrZ[left] > arrZ[i])
			max = left;
		if (right <= N && arrZ[right] > arrZ[max])
			max = right;

		if (max != i) {
			swap(arrZ, i, max);
			maxheap(arrZ, max);
		}
	}

	/* Function to swap two numbers in an array */
	public static void swap(int arrA[], int i, int j) {
		int tmp = arrA[i];
		arrA[i] = arrA[j];
		arrA[j] = tmp;
	}
}