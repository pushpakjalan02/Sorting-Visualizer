import javax.swing.JFrame;  
import java.awt.GridLayout;

class Main{
	int array[];
	int length;
	Main(){
		this.length = 100;
		this.array = new int[100];
		for(int i = 0; i < this.length; i++){
			this.array[i] = (int)(Math.random() * (1000 - 1 + 1)) + 1;
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

	public static void main(String args[]){
		Main p = new Main();
		InsertionSort i = new InsertionSort(p.length, p.array);
		QuickSort q = new QuickSort(p.length, p.array);
		SelectionSort s = new SelectionSort(p.length, p.array);
		MergeSort m = new MergeSort(p.length, p.array);

		JFrame frame = new JFrame("Visualizer");
		frame.setLayout(new GridLayout(2,2));

		Plot plotInsertionSort = new Plot(frame, p.array, "Insertion Sort");
		Plot plotQuickSort = new Plot(frame, p.array, "Quick Sort");
		Plot plotSelectionSort = new Plot(frame, p.array, "Selection Sort");
		Plot plotMergeSort = new Plot(frame, p.array, "Merge Sort");

		frame.pack();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);

		Threads iSort = new Threads(i, plotInsertionSort, 1);
		Threads qSort = new Threads(q, plotQuickSort, 2);
		Threads sSort = new Threads(s, plotSelectionSort, 3);
		Threads mSort = new Threads(m, plotMergeSort, 4);
		iSort.start();
		qSort.start();
		sSort.start();
		mSort.start();
	}
}