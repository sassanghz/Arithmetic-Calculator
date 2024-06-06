
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

	public E pop() {
		if (isEmpty())
			return null;
		E top = data[size];
		data[size] = null;
		size--;
		return top;
	}

	public E top() {
		if (isEmpty())
			return null;
		return data[size];
	}
}
