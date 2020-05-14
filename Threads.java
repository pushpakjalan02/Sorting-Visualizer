class Threads extends Thread{
	private InsertionSort i;
	private QuickSort q;
	private SelectionSort s;
	private MergeSort m;
	private Plot p;
	private int sortMethod;
	Threads(Object sortClass, Plot p, int sortMethod){
		this.p = p;
		this.sortMethod = sortMethod;
		switch(this.sortMethod){
			case 1: this.i = (InsertionSort)sortClass;
				break;
			case 2: this.q = (QuickSort)sortClass;
				break;
			case 3: this.s = (SelectionSort)sortClass;
				break;
			case 4: this.m = (MergeSort)sortClass;
				break;
		}
	}
	public void run(){
		try{
			switch(this.sortMethod){
				case 1: this.i.sortArray(p);
					break;
				case 2: this.q.sortArray(p);
					break;
				case 3: this.s.sortArray(p);
					break;
				case 4: this.m.sortArray(p);
					break;
			}
		}
		catch(Exception e){
			System.out.println("An Error Occured");
		}
	}
}