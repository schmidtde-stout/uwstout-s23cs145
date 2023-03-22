import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class ManualArrayListTest {

	@Test
	void testEmptyGet() {
		ManualArrayList list = new ManualArrayList();
		try {
			Integer value = list.get(20);
			fail("Didn't throw exception");
		}
		catch (ArrayIndexOutOfBoundsException ex) {
			
		}
	}

	@Test
	void testEmptySet() {
		ManualArrayList list = new ManualArrayList();
		try {
			list.set(0, 123);
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			
		}
	}

	@Test
	void testAdd() {
		ManualArrayList list = new ManualArrayList();
		list.add(123);
		Integer value = list.get(0);
		assertEquals(value, 123);
		assertEquals(list.getSize(), 1);
	}

	
	@Test
	void testAddTooMany() {
		ManualArrayList list = new ManualArrayList();
		for(int i = 0; i < 20; i++) {
			list.add(i);
		}
	}
	
	
	@Test
	void testTraverseList() {
		ManualArrayList list = new ManualArrayList();
		for(int i = 0; i < 20; i++) {
			list.addToEnd(i);
		}
		list.walk();	
	}

}
