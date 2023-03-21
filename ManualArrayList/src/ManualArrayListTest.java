import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class ManualArrayListTest {

	@Test
	void testEmptyGet() {
		ManualArrayList list = new ManualArrayList();
		Integer value = list.get(20);
		assertEquals(value, null);
	}

	@Test
	void testEmptySet() {
		ManualArrayList list = new ManualArrayList();
		try {
			list.set(0, 123);
			fail("Didn't throw exception");
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			
		}
	}
}
