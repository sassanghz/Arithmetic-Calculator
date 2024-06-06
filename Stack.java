
public class Stack<E> {
	private static final int CAPACITY = 1;
	private E[] data;
	private int size = 0;
	
	public Stack(int size) {
		data = (E[]) new Object[size];
	}
	public Stack() {
		this(CAPACITY);
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	public void push(E e){
		// TODO Auto-generated method stub
		if (size == data.length - 1) {
			resize(data.length * 2);
			System.out.println(data.length + " " + e);
		}
		data[size] = e;
		size++;
	}
	public void resize(int size) {
		E[] temp = (E[]) new Object[size];
		for (int i = 0; i < data.length; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}

	public E pop() {
		// TODO Auto-generated method stub
		if (isEmpty())
			return null;
		E top = data[size];
		data[size] = null;
		size--;
		return top;
	}

	public E top() {
		// TODO Auto-generated method stub
		if (isEmpty())
			return null;
		return data[size];
	}
}
