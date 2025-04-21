//2023/05/05
import java.util.Random;

public class RecursiveSorterAnalysis {

	public static void main(String[] args) {
		createTable();
//		createSummary();
	}
	
	static void createTable() {

        RecursiveSorter sorter = new RecursiveSorter();
        SorterUtilities utility = new SorterUtilities();
		Random generator = new Random();
        generator.setSeed(12345);  //do not change this statement
        
        			
		System.out.print(String.format("%6s", ""));
		for (int i = 0; i < 6; i++) {
			System.out.print(String.format("%12s","random"));			
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(String.format("%12s","nearly"));			
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(String.format("%12s","reverse"));			
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(String.format("%12s","few unique"));			
		}
		
		System.out.println();
		
		
		System.out.print(String.format("%6s", "n"));
		for (int i = 0; i < 4; i++) {
			System.out.print(String.format("%12s%12s%12s", "QS-reads", "QS-writes", "QS-space"));
			System.out.print(String.format("%12s%12s%12s", "MS-reads", "MS-writes", "MS-space"));
		}
		System.out.println();
		
		for (int n = 100; n <= 10000; n+=100){
			///////////////////////////////////RANDOM
			IntegerArray arrayToSort = null;
						
			System.out.print(String.format("%6d",n));

			arrayToSort = utility.createRandomArray(n);
			IntegerArray.reset();
			sorter.doQuickSort(arrayToSort);
			System.out.print(String.format("%12d%12d%12d", arrayToSort.getReads(), arrayToSort.getWrites(), arrayToSort.getSpaces()));

			arrayToSort = utility.createRandomArray(n);
			IntegerArray.reset();
			sorter.doMergeSort(arrayToSort);
			System.out.print(String.format("%12d%12d%12d", arrayToSort.getReads(), arrayToSort.getWrites(), arrayToSort.getSpaces()));

			///////////////////////////////////NEARLY SORTED
			arrayToSort = utility.createNearlySortedArray(n);			
			IntegerArray.reset();
			sorter.doQuickSort(arrayToSort);
			System.out.print(String.format("%12d%12d%12d", arrayToSort.getReads(), arrayToSort.getWrites(), arrayToSort.getSpaces()));

			arrayToSort = utility.createNearlySortedArray(n);
			IntegerArray.reset();
			sorter.doMergeSort(arrayToSort);
			System.out.print(String.format("%12d%12d%12d", arrayToSort.getReads(), arrayToSort.getWrites(), arrayToSort.getSpaces()));

			///////////////////////////////////REVERSE ORDER
			arrayToSort = utility.createReverseOrderArray(n);						
			IntegerArray.reset();
			sorter.doQuickSort(arrayToSort);
			System.out.print(String.format("%12d%12d%12d", arrayToSort.getReads(), arrayToSort.getWrites(), arrayToSort.getSpaces()));

			arrayToSort = utility.createReverseOrderArray(n);						
			IntegerArray.reset();
			sorter.doMergeSort(arrayToSort);
			System.out.print(String.format("%12d%12d%12d", arrayToSort.getReads(), arrayToSort.getWrites(), arrayToSort.getSpaces()));

			///////////////////////////////////FEW UNIQUE
			arrayToSort = utility.createFewUniqueArray(n);			
			IntegerArray.reset();
			sorter.doQuickSort(arrayToSort);
			System.out.print(String.format("%12d%12d%12d", arrayToSort.getReads(), arrayToSort.getWrites(), arrayToSort.getSpaces()));

			arrayToSort = utility.createFewUniqueArray(n);			
			IntegerArray.reset();
			sorter.doMergeSort(arrayToSort);
			System.out.print(String.format("%12d%12d%12d", arrayToSort.getReads(), arrayToSort.getWrites(), arrayToSort.getSpaces()));

			System.out.println();
		}

		System.out.println();
		
	}

}