
public class ListController {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> myList = new List<Integer>();

		
		for (int i = 0; i < 10; i++) {
			myList.addItemAtEnd(new ListItem<Integer>(i, null));
			
		}

		myList.showList();
		System.out.println("-------------");
		myList.duplicateEachElem();
		myList.showList();
		System.out.println("-------------");
		myList.removeEachOther();
		myList.showList();
		myList.rotateTriples();
		myList.showList();
	}

}
