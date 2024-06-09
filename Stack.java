
public class Stack {

    private String [] stack;
    private int size;

    public Stack(){
        this.stack = new String[1];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(String value){
        if(this.size == this.stack.length){
            this.resize();
        }
        this.size++;
        this.stack[this.size] = value;
    }

    public void resize() {
        int stackSize = this.stack.length;
        String[] sizeArray = new String[stackSize*2];

        System.arraycopy(this.stack, 0, sizeArray, 0, stackSize);
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
        return this.stack[this.size-1];
    }

    public void printStack(){
        System.out.println("\nLast stack : " + this.size);
        System.out.println("Elements in the following stacks are listed : ");

        for(int i = 0; i < this.size; i++){
            System.out.print(this.stack[i] + ", ");
        }
        System.out.println();
    }

}
