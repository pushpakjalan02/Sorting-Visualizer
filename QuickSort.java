import org.jfree.data.category.DefaultCategoryDataset; 

// Class for QuickSort Sorting Algorithm
class QuickSort{

	// Private Variables
	private int array[];
	private int length;

	// Constructor
	QuickSort(int length, int array[]){
		this.length = length;
		this.array = new int[this.length];
		for(int i = 0; i < this.length; i++){
			this.array[i] = array[i];
		}
	}

	// Lomuto's Partitioning Algorithm
	private int partition(Plot p, int start, int end){
		
		// Picking a Random Pivot
		int pivot = (int)(Math.random() * (end - start + 1)) + start;
		
		// Swapping array[pivot] with array[end]
		int temp = this.array[pivot];
		this.array[pivot] = this.array[end];
		this.array[end] = temp;
		p.getDataset().setValue(this.array[pivot], Integer.toString(pivot), "");
		p.getDataset().setValue(this.array[end], Integer.toString(end), "");
		p.delay();

		// Updating pivot's value
		pivot = end;

		// Partitioning the array
		int j = start;
		for(int i = start; i <= end; i++){
			if(this.array[i] <= this.array[pivot]){
				temp = this.array[j];
				this.array[j] = this.array[i];
				this.array[i] = temp;
				p.getDataset().setValue(this.array[i], Integer.toString(i), "");
				p.getDataset().setValue(this.array[j], Integer.toString(j), "");
				p.delay();
				j++;
			}
		}

		// Pivot is the element previous to current j
		return (j - 1);
	}

	// QuickSort Sorting
	private void sortArray(Plot p, int start, int end){
		if(start < end){
			int pivot = partition(p, start, end);
			sortArray(p, start, pivot - 1);
			sortArray(p, pivot + 1, end);
		}
		return;
	}

	// Overloaded function for providing default values
	public void sortArray(Plot p){
		sortArray(p, 0, this.length - 1);
	}

	// Display Function
	public void display(){
		for(int i = 0; i < this.length; i++){
			System.out.print(this.array[i] + " ");
		}
		System.out.println();
	} 
}