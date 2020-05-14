import org.jfree.data.category.DefaultCategoryDataset; 

// Class for InsertionSort Sorting Algorithm
class InsertionSort{

	// Private Variables
	private int array[];
	int length;

	// Constructor
	InsertionSort(int length, int array[]){
		this.length = length;
		this.array = new int[this.length];
		for(int i = 0; i < this.length; i++){
			this.array[i] = array[i];
		}
	}

	// InsertionSort Sorting
	public void sortArray(Plot p){

		// Inserting current element to correct position in the sub-array to its left
		for(int i = 1; i < this.length; i++){

			int temp = this.array[i];
			
			// Right shift elements in the left of current element by one if they are 
			// bigger than the current element
			int j = i - 1;
			while(j >= 0){
				if(temp < this.array[j]){
					this.array[j + 1] = this.array[j];
					p.getDataset().setValue(this.array[j + 1], Integer.toString(j + 1), "");
					p.delay();
				}
				else{
					break;
				}
				j--;
			}

			// Insert current element to the correct position found
			this.array[j + 1] = temp;
			p.getDataset().setValue(this.array[j + 1], Integer.toString(j + 1), "");
			p.delay();
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