//2023/05/05

import junit.framework.TestCase;

public class RecursiveSorterTest extends TestCase {

	private SorterUtilities utility = new SorterUtilities();
	private RecursiveSorter sorter = new RecursiveSorter();

	//this method is not a unit test by itself but is called by tests of QuickSort on various types of data.
	private void testQuickSort(IntegerArray arrayToSort) {
		long originalCheckSum = utility.checkSum(arrayToSort);
		IntegerArray.reset();
		sorter.doQuickSort(arrayToSort);
		//you can place a breakpoint here to see the results of your sort, including metrics
		assertEquals(true, utility.verifySort(arrayToSort) );		
		long sortedCheckSum = utility.checkSum(arrayToSort);
		assertEquals(originalCheckSum, sortedCheckSum);
	}

	//this method is not a unit test by itself but is called by tests of MergeSort on various types of data.
	private void testMergeSort(IntegerArray arrayToSort) {
		long originalCheckSum = utility.checkSum(arrayToSort);
		IntegerArray.reset();
		sorter.doMergeSort(arrayToSort);
		assertEquals(true, utility.verifySort(arrayToSort) );		
		long sortedCheckSum = utility.checkSum(arrayToSort);
		assertEquals(originalCheckSum, sortedCheckSum);
	}
	
	public void testQuickSortRandom() {

		testQuickSort(utility.createRandomArray(10));
		testQuickSort(utility.createRandomArray(1000));
		
	}

	public void testQuickSortNearlySorted() {

		testQuickSort(utility.createNearlySortedArray(10));
		testQuickSort(utility.createNearlySortedArray(1000));
		
	}

	public void testQuickSortFewUniqueArray() {

		testQuickSort(utility.createFewUniqueArray(10));
		testQuickSort(utility.createFewUniqueArray(1000));

	}
	
	public void testQuickSortReverseOrder() {

		testQuickSort(utility.createReverseOrderArray(10));
		testQuickSort(utility.createReverseOrderArray(1000));

	}

	public void testMergeSortRandom() {

		testMergeSort(utility.createRandomArray(10));
		testMergeSort(utility.createRandomArray(1000));
		
	}

	public void testMergeSortNearlySorted() {

		testMergeSort(utility.createNearlySortedArray(10));
		testMergeSort(utility.createNearlySortedArray(1000));

	}

	public void testMergeSortFewUniqueArray() {

		testMergeSort(utility.createFewUniqueArray(10));
		testMergeSort(utility.createFewUniqueArray(1000));

	}
	
	public void testMergeSortReverseOrder() {

		testMergeSort(utility.createReverseOrderArray(10));
		testMergeSort(utility.createReverseOrderArray(1000));

	}
			
}
