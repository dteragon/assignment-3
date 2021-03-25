import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedList_STUDENT_Test {
	
	BasicDoubleLinkedList<String> names;
	String s1 = "Jeffrey";
	String s2 = "Angela";
	String s3 = "Kyle";
	String s4 = "Penelope";
	
	BasicDoubleLinkedList<Double> gpa;
	double d1 = 3.4;
	double d2 = 4.1;
	double d3 = 2.56;
	double d4 = 3;
	double d5 = 3.21;
	
	@Before
	public void setUp() throws Exception {
		
		names = new BasicDoubleLinkedList<>();
		names.addToFront(s2);
		names.addToFront(s1);
		
		gpa = new BasicDoubleLinkedList<>();
		gpa.addToFront(d3);
		gpa.addToFront(d2);
	}

	@After
	public void tearDown() throws Exception {
		names = null;
		gpa = null;
	}
	
	@Test
	public void testAddToFront() {
		
		gpa.addToFront(d1);
		assertEquals(gpa.getFirst(), new Double(d1));
		gpa.addToFront(d4);
		assertEquals(gpa.getFirst(), new Double(d4));
	}
	
	@Test
	public void testAddToEnd() {
		
		gpa.addToEnd(d4);
		assertEquals(gpa.getLast(), new Double(d4));
		gpa.addToEnd(d5);
		assertEquals(gpa.getLast(), new Double(d5));
		
		names.addToEnd(s3);
		assertEquals(names.getLast(), s3);
		names.addToEnd(s4);
		assertEquals(names.getLast(), s4);
	}
}
