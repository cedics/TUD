package listPackage;

public class List<T> {
	ListItem<T> first;

	/**
	 * constructor
	 */
	public List()
	{
	this.first = null;
	}
	
	
	public void addItemAtEnd( ListItem<T> item){
		ListItem<T> tempItem;

		if(first != null){
			tempItem = first;
			while(tempItem.next != null){
				tempItem = tempItem.next;
			}
			if(tempItem.next == null){
				tempItem.next = item;
			}
			
		}else{
			this.first = item;

		}
		
	}
	
	void showList(){
		System.out.println("-------------");
		ListItem<T> tempItem;
		if(first != null){
			if(first.next != null){
				tempItem = first;
				while(tempItem.next != null){
					System.out.println("Key:"+ tempItem.key);
					tempItem = tempItem.next;
					
				}
					System.out.println("Key:"+ tempItem.key);
				
			}else{
				System.out.println("Key:"+ first.key);

			}
		}else{
			System.out.println("List empty.");
		}
	}
	
	
	
	public void duplicateEachElem(){
		System.out.println("duplicateEachElem(): Start!");
		if(first != null){
			ListItem<T> tempItem,copyItem;
			
			tempItem = first;
			while(tempItem.next != null){
				
				copyItem = new ListItem(tempItem.key, tempItem.next);
				tempItem.next= copyItem;
				tempItem = copyItem.next;

				}
				tempItem.next= new ListItem(tempItem.key, tempItem.next);

			
				
		}else{
				System.out.println("duplicateEachElement() - Liste leer!");

			}
	}

	public void duplicateEachElemRecursiv(){
		System.out.println("duplicateEachElemRecursiv(): Start!");
		if(first != null){
			duplicateEachElemRecursivHelper(first);
		}else{
			System.out.println("duplicateEachElementRecursiv() - Liste leer!");
		}
		
	}
	private void duplicateEachElemRecursivHelper(ListItem<T> toCopy){
		if(toCopy.next == null){
			toCopy.next= new ListItem(toCopy.key, toCopy.next);
			return;
		}else{
			toCopy.next= new ListItem(toCopy.key, toCopy.next);
			duplicateEachElemRecursivHelper(toCopy.next.next);
		}
	}
	
	public void removeEachOther(){
		System.out.println("removeEachOther: Start!");
		if(first == null){
			System.out.println("removeEachOther - Liste leer!");
		}else{
			ListItem<T> tempItem,copyItem;
			
			tempItem = first;
			while(tempItem.next != null){
				
				if(tempItem.next.next != null){
					
			
				tempItem.next= tempItem.next.next;
				tempItem = tempItem.next;

				}else{
					tempItem.next = null;
					break;
				}
				

			
		}
	}
}
	
	public void removeEachOtherRecursiv(){
		System.out.println("removeEachOtherRecursiv: Start!");

		if(first == null){
			System.out.println("removeEachOtherRecursiv - Liste leer!");
		}else{
			removeEachOtherRecursivHelper(first);	
			return;
		}
		return;
	}
	
	private void removeEachOtherRecursivHelper(ListItem<T> toRemove){
		if(toRemove == null)return;
		
		if(toRemove.next != null){
			if(toRemove.next.next != null){
				toRemove.next = toRemove.next.next;
				removeEachOtherRecursivHelper(toRemove.next);
				return;
			}else{
				toRemove.next = null;
				return;
			}
		}else{
			return;
		}
		
	}
	
	void rotateTriples(){
		System.out.println("rotateTriplesRecursiv(): Start!");
		/*
		 * Startcheck
		 */
		if(first == null || first.next == null || first.next.next == null){
			System.out.println("rotateTriples(): Nothing to rotate.");
			return;
		}
		ListItem<T> itemA = first;
		ListItem<T> itemB = itemA.next;
		ListItem<T> itemC = itemB.next; // 1. C merken
		ListItem<T> itemD = null;
	
		first = itemC;
		
		//4. B.next setzen
		if(itemC.next == null){
			itemB.next = null;							//B -> null
		}else{
			if(itemC.next.next == null){
				// 3. D merken
				itemD = itemC.next;
				itemB.next = itemC.next;				//B -> D
			}else{
				if(itemC.next.next.next == null){
					// 3. D merken
					itemD = itemC.next;
				itemB.next = itemC.next;		
				}else{
					// 3. D merken
					itemD = itemC.next;
					itemB.next = itemC.next.next.next; //B -> F
			}
		}
		
	}
		
	//4. C.next setzen
	itemC.next = itemA;
	if(itemD != null){itemA = itemD;}else{return;}
	
	//Schleife
	while((itemA.next != null) && (itemA.next.next != null)){
		itemB = itemA.next;
		itemC = itemB.next;
		itemD = itemC.next;
		
		//4. B.next setzen
		if(itemD == null){
			itemB.next = null;							//B -> null
		}else{
			if(itemD.next == null){
				itemB.next = itemD;						//B -> D
			}else{
				if(itemD.next.next == null){
				itemB.next = itemD;						//B -> D
				}else{
					itemB.next = itemD.next.next;  //B -> F
			}
		}
		
	}
		
		//4. C.next setzen
		itemC.next = itemA;
		if(itemD != null){itemA = itemD;}else{return;}
		
	}
	return;

}
	

public void rotateTriplesRecursiv(){
	System.out.println("rotateTriplesRecursiv(): Start!");
	/*
	 * Startcheck
	 */
	if(first == null || first.next == null || first.next.next == null){
		System.out.println("rotateTriplesRecursiv(): Nothing to rotate.");
		return;
	}
	
	ListItem<T> itemA = first;
	ListItem<T> itemB = itemA.next;
	ListItem<T> itemC = itemB.next; // 1. C merken
	ListItem<T> itemD = null;

	first = itemC;
	
	//4. B.next setzen
	if(itemC.next == null){
		itemB.next = null;							//B -> null
	}else{
		if(itemC.next.next == null){
			// 3. D merken
			itemD = itemC.next;
			itemB.next = itemC.next;				//B -> D
		}else{
			if(itemC.next.next.next == null){
				// 3. D merken
				itemD = itemC.next;
			itemB.next = itemC.next;		
			}else{
				// 3. D merken
				itemD = itemC.next;
				itemB.next = itemC.next.next.next; //B -> F
		}
	}
	
}
	
//4. C.next setzen
itemC.next = itemA;
if(itemD != null){itemA = itemD;}else{return;}
rotateTriplesRecursivHelper(itemA);
}

private void rotateTriplesRecursivHelper(ListItem<T> itemA){
if((itemA.next != null) && (itemA.next.next != null)){
		ListItem<T>itemB = itemA.next;
		ListItem<T>itemC = itemB.next;
		ListItem<T>itemD = itemC.next;
		
		//4. B.next setzen
		if(itemD == null){
			itemB.next = null;							//B -> null
		}else{
			if(itemD.next == null){
				itemB.next = itemD;						//B -> D
			}else{
				if(itemD.next.next == null){
				itemB.next = itemD;						//B -> D
				}else{
					itemB.next = itemD.next.next;  //B -> F
			}
		}
		
	}
		
		//4. C.next setzen
		itemC.next = itemA;
		if(itemD != null){itemA = itemD;}else{return;}
		rotateTriplesRecursivHelper(itemA);
	}return;
}
}


