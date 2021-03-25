import static org.junit.Assert.*;

import java.util.Comparator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortedDoubleLinkedList_STUDENT_Test {
	
	SortedDoubleLinkedList<Integer> numbers;
	int n1 = 12;
	int n2 = 0;
	int n3 = -7;
	int n4 = 639;
	int n5 = 3;
	
	SortedDoubleLinkedList<Character> letters;
	char a = 'a';
	char b = 'b';
	char c = 'c';
	char d = 'd';
	char e = 'e';
	
	@Before
	public void setUp() throws Exception {
		
		numbers = new SortedDoubleLinkedList<>(new IntComparator());
		numbers.add(n1);
		numbers.add(n2);
		
		letters = new SortedDoubleLinkedList<>(new CharComparator());
		letters.add(d);
		letters.add(b);
		letters.add(a);
		letters.add(e);
		letters.add(c);
	}

	@After
	public void tearDown() throws Exception {
		
		numbers = null;
		letters = null;
	}
	
	@Test
	public void testAdd() {
		
		numbers.add(n3);
		assertEquals(numbers.getFirst(), new Integer(n3));
		numbers.add(n4);
		assertEquals(numbers.getLast(), new Integer(n4));
		numbers.add(n5);
		assertEquals(numbers.getFirst(), new Integer(n3));
		assertEquals(numbers.getLast(), new Integer(n4));
		assertEquals(new Integer(numbers.getSize()), new Integer(5));
	}
	
	@Test
	public void testRemove() {
		
		SortedDoubleLinkedList<Character> testRem = letters.remove(a, new CharComparator());
		assertEquals(testRem.getFirst(), new Character(b));
		testRem = letters.remove(b, new CharComparator());
		assertEquals(testRem.getFirst(), new Character(c));
		testRem = letters.remove(c, new CharComparator());
		assertEquals(testRem.getFirst(), new Character(d));
		testRem = letters.remove(d, new CharComparator());
		assertEquals(testRem.getFirst(), new Character(e));
		testRem = letters.remove(e, new CharComparator());
		assertEquals(testRem.getFirst(), null);
		
	}
	
	private class IntComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer arg0, Integer arg1) {
			return arg0.compareTo(arg1);
		}
	}
	
	private class CharComparator implements Comparator<Character> {
		@Override
		public int compare(Character arg0, Character arg1) {
			return arg0.compareTo(arg1);
		}
	}
}
