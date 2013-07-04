package listPackage;

public class ListController {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> myList = new List<String>();
		ListItem<String> itemK = new ListItem<String>("K", null);
		ListItem<String> itemJ = new ListItem<String>("J", itemK);
		ListItem<String> itemI = new ListItem<String>("I", itemJ);
		ListItem<String> itemH = new ListItem<String>("H", itemI);
		ListItem<String> itemG = new ListItem<String>("G", itemH);
		ListItem<String> itemF = new ListItem<String>("F", itemG);
		ListItem<String> itemE = new ListItem<String>("E", itemF);
		ListItem<String> itemD = new ListItem<String>("D", itemE);
		ListItem<String> itemC = new ListItem<String>("C", itemD);
		ListItem<String> itemB = new ListItem<String>("B", itemC);
		ListItem<String> itemA = new ListItem<String>("A", itemB);
		myList.first = itemA;
		
		
		
		myList.showList();
		myList.duplicateEachElem();
		myList.showList();
		myList.removeEachOther();
		myList.showList();
		myList.duplicateEachElemRecursiv();
		myList.showList();
		myList.removeEachOtherRecursiv();
		myList.showList();
		myList.rotateTriples();
		myList.showList();
		
	}

}
