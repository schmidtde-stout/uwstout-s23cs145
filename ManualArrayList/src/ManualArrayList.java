
public class ManualArrayList {
	
	private Integer[] list; 
	private int size;
	
	public ManualArrayList() {
		list = new Integer[10];
		size = 0;
	}
	
	public Integer get(int i) {
		if (i >= 0 && i < size) {
			return list[i];
		}
		// throw new ArrayIndexOutOfBoundsException();
		return null;
	}
	
	public void set(int i, Integer data) {
		if (i >= 0 && i < size) {
			list[i] = data;
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public void add(Integer data) {
		
	}

}
