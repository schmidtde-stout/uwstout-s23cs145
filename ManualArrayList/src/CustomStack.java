
public class CustomStack extends ManualArrayList {
	
	public void push(Integer data) {
		this.addToFront(data);
	}
	
	public Integer pop() {
		return this.removeFromFront();
	}

	public static void main(String[] args) {
		CustomStack myStack = new CustomStack();
		
		myStack.push(10);
		myStack.push(20);
		myStack.push(30);
		myStack.push(40);
		
		
		myStack.walk();
		
		System.out.println(myStack.pop());
		
		myStack.walk();		


	}

}
