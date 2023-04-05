
public class CustomQueue extends ManualArrayList {

	public void add(Integer data) {
		this.addToEnd(data);
	}
	
	public Integer remove() {
		return this.removeFromFront();
	}

}
