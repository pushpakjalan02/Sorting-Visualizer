import org.jfree.data.category.DefaultCategoryDataset; 

// Class for MergeSort Sorting Algorithm
class MergeSort{

	// Private Variables
	private int array[];
	private int length;

	// Constructor
	MergeSort(int length, int array[]){
		this.length = length;
		this.array = new int[this.length];
		for(int i = 0; i < this.length; i++){
			this.array[i] = array[i];
		}
	}

	// Private function for slicing an array
	private void copyArray(int copy[], int start, int end){
		for(int i = start; i <= end; i++){
			copy[i - start] = this.array[i];
		}
		return;
	}

	// Merge two sorted arrays to form another sorted array
	private void mergeArray(Plot p, int start, int mid, int end){

		// Create and Copy Left and Right Arrays
		int arrayLeft[] = new int[mid - start + 1];
		int arrayRight[] = new int[end - mid];
		copyArray(arrayLeft, start, mid);
		copyArray(arrayRight, mid + 1, end);

		// Compare elements from both the arrays and push the shorter one's first
		int i = 0;
		int j = 0; 
		int k = start;
		while(i < mid - start + 1 && j < end - mid){
			if(arrayLeft[i] <= arrayRight[j]){
				this.array[k] = arrayLeft[i];
				i++;
			}
			else{
				this.array[k] = arrayRight[j];
				j++;
			}
			p.getDataset().setValue(this.array[k], Integer.toString(k), "");
			p.delay();
			k++;
		}

		// Push remaining elements of left array, if any
		while(i < mid - start + 1){
			this.array[k] = arrayLeft[i];
			p.getDataset().setValue(this.array[k], Integer.toString(k), "");
			p.delay();
			i++;
			k++;
		}

		// Push remaining elements of right array, if any
		while(j < end - mid){
			this.array[k] = arrayRight[j];
			p.getDataset().setValue(this.array[k], Integer.toString(k), "");
			p.delay();
			j++;
			k++;
		}
		return;
	}

	// MergeSort Sorting
	private void sortArray(Plot p, int start, int end){
		if(start < end){
			int mid = start + (end - start) / 2;
			sortArray(p, start, mid);
			sortArray(p, mid + 1, end);
			mergeArray(p, start, mid, end);
		}
		return;
	}

	// Overloaded function to provide default values
	public void sortArray(Plot p){
		sortArray(p, 0, this.length - 1);
		return;
	}

	// Display Function
	public void display(){
		for(int i = 0; i < this.length; i++){
			System.out.print(this.array[i] + " ");
		}
		System.out.println();
	} 
}