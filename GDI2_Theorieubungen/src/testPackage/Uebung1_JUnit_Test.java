package testPackage;
import static org.junit.Assert.*;
import listPackage.List;
import listPackage.ListItem;

import org.junit.Before;
import org.junit.Test;


public class Uebung1_JUnit_Test {

	List<Integer> myList = new List<Integer>();
	
	@Before
	public void setUpList(){
		for (int i = 0; i < 3; i++) {
			myList.addItemAtEnd(new ListItem<Integer>(i, null));
			
		}
	}
	
	@Test
	public void testRotateTriple() {

		
	}

}
