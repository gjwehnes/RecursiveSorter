//2025/04/21
import java.util.Random;

public class RecursiveSorterPerformance {
	
	public static void main(String[] args) {
		
        RecursiveSorter sorter = new RecursiveSorter();
        SorterUtilities utility = new SorterUtilities();        
	    Random generator = new Random();
        generator.setSeed(12345);
        
		//2 sorts x 2 metrics x 4 data sets
		System.out.print(String.format("%6s\t", "n"));
		System.out.print(formatHeader("random").repeat(4));			
		System.out.print(formatHeader("nearly").repeat(4));			
		System.out.print(formatHeader("reverse").repeat(4));			
		System.out.print(formatHeader("few_unique").repeat(4));			
		System.out.println();

		System.out.print(String.format("%6s\t", "n"));
		System.out.print( (formatHeader("QS").repeat(2) +
							formatHeader("MS").repeat(2)).repeat(4));
		System.out.println();
		
		System.out.print(String.format("%6s\t", "n"));
		System.out.print( (formatHeader("T(n)/nlogn") + formatHeader("S(n)/nlogn") +
							formatHeader("T(n)/nlogn") + formatHeader("S(n)/nlogn") ).repeat(4));
		System.out.println();
        		
		for (int n = 1000; n <= 10000; n+=1000){
			
			if (n == 10000) {
				System.out.println("------");
			}
			IntegerArray arrayToSort = null;
						
			System.out.print(String.format("%6d",n));

			///////////////////////////////////RANDOM
			arrayToSort = utility.createRandomArray(n);
			IntegerArray.reset();
			sorter.doQuickSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			arrayToSort = utility.createRandomArray(n);
			IntegerArray.reset();
			sorter.doMergeSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			///////////////////////////////////NEARLY SORTED
			arrayToSort = utility.createNearlySortedArray(n);			
			IntegerArray.reset();
			sorter.doQuickSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			arrayToSort = utility.createNearlySortedArray(n);
			IntegerArray.reset();
			sorter.doMergeSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			///////////////////////////////////REVERSE ORDER
			arrayToSort = utility.createReverseOrderArray(n);						
			IntegerArray.reset();
			sorter.doQuickSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			arrayToSort = utility.createReverseOrderArray(n);						
			IntegerArray.reset();
			sorter.doMergeSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			///////////////////////////////////FEW UNIQUE
			arrayToSort = utility.createFewUniqueArray(n);			
			IntegerArray.reset();
			sorter.doQuickSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			arrayToSort = utility.createFewUniqueArray(n);			
			IntegerArray.reset();
			sorter.doMergeSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			System.out.println();
		}

		System.out.println();
	}

	private static String formatHeader(String columnHeader) {
		return String.format("%15s\t",columnHeader);
	}

	private static String formatValues(long value, double divisor) {
		return String.format("%15.3f\t", value / divisor);
	}
	
	private static String formatTest(IntegerArray arrayToSort, long n) {
		return formatValues(arrayToSort.getReads() + arrayToSort.getWrites(), n * (Math.log(n) / Math.log(2)))		
				+ formatValues((arrayToSort.getSpaces() + n), n);
	}

}