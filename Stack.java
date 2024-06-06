
public class Stack {

	private String [] stack;
	private int size;
	
	public Stack(){
		this.stack = new String[1];
		this.size = -1;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void push(String value){
		if(this.size+1 == this.stack.length){
			this.resize();
		}

		this.size++;
		this.stack[this.size] = value;
	}

	public void resize() {
		int stackSize = this.stack.length;
		String[] sizeArray = new String[stackSize*2];
		
		for(int i = 0; i < stackSize; i++){
			sizeArray[i] = this.stack[i];
		}

		this.stack = new String[stackSize*2];
		this.stack = sizeArray;
	}

	public String pop() {
		if (isEmpty()) return null;
		
		String lastElem = this.stack[this.size];
		this.stack[this.size] = null;
		this.size--;
		return lastElem;
	}

	public String peek(){
		if(isEmpty()) return null;
		return this.stack[this.size];
	}

	public void newSize(){
		String [] newSTK = new String[this.size+1];

		for(int i = 0; i < newSTK.length; i++){
			newSTK[i] = this.stack[i];
		}

		this.stack = newSTK;
	}

	public void printStack(){
		System.out.println("\nLast stack : " + this.size);
		System.out.println("Elements in the following stacks are listed : ");

		for(int i = 0; i < this.size+1; i++){
			System.out.print(this.stack[i] + ", ");
		}
	}

}
