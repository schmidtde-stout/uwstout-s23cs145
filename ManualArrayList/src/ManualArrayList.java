
public class ManualArrayList {
	
	private Integer[] list; 
	private int size;
	
	private Node first;
	
	public ManualArrayList() {
		list = new Integer[10];
		size = 0;
		first = null;
	}
	
	public Integer get(int i) {
		if (i >= 0 && i < size) {
			return list[i];
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public void set(int i, Integer data) {
		if (i >= 0 && i < size) {
			list[i] = data;
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	// we are growing capacity, implicitly tracked by list.length
	private void grow() {
		Integer[] newArray = new Integer[list.length + 10];
		for(int i = 0; i < size; i++) {
			newArray[i] = list[i];
		}
		list = newArray;
	}
	
	public void add(Integer data) {
		if (size >= list.length) {
			grow();
		}
		list[size] = data;
		size++;
	}
	
	public void addLink(Integer data) {
		
	}
	
	public void walk() {
		
		Node n = first;
		while(n != null) {
			System.out.println(n.data);
			n = n.next;
		}
		
	}
	
	
	public int getSize() {
		return size;
	}

}
