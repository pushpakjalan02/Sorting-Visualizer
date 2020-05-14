import org.jfree.data.category.DefaultCategoryDataset; 

// Class for SelectionSort Sorting ALgorithm
class SelectionSort{

	// Private Variables
	private int array[];
	private int length;

	// Constructor
	SelectionSort(int length, int array[]){
		this.length = length;
		this.array = new int[this.length];
		for(int i = 0; i < array.length; i++){
			this.array[i] = array[i];
		}
	}

	// SelectionSort Sorting
	public void sortArray(Plot p){

		for(int i = 0; i < this.length - 1; i++){
			
			// Assume current minimum to be first element in sub-array and start finding the minimum
			int min = i;
			for(int j = i+1; j < this.length; j++){
				if(this.array[j] < this.array[min]){
					min = j;
				}
			}
			
			// If minimum in current sub-array is not in correct position, swap it!
			if(i != min){
				int temp = this.array[min];
				this.array[min] = this.array[i];
				this.array[i] = temp;
				p.getDataset().setValue(this.array[min], Integer.toString(min), "");
				p.getDataset().setValue(this.array[i], Integer.toString(i), "");
				p.delay();
			}

		}

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