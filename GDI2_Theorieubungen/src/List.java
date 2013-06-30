
public class List<T> {
	private ListItem<T> first;

	/**
	 * constructor
	 */
	public List()
	{
	this.first = null;
	}
	
	
	void addItemAtEnd( ListItem<T> item){
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
	
	
	
	void duplicateEachElem(){
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

		
	void removeEachOther(){
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
	
	
	void rotateTriples(){
		System.out.println("rotateTriples(): Start!");
		if(first == null || first.next.next == null){
			System.out.println("rotateTriples(): nothing to rotate!");
		}else{
			
			ListItem<T>  preItem,tempItem,item1,item2,item3;	
			tempItem = first;
			if(tempItem.next.next != null)
				preItem = tempItem.next.next;

			while(true){
				if(tempItem == null || tempItem.next == null || tempItem.next.next == null)
					break;
			
			item1 = tempItem;		System.out.println("rotateTriples,Key:"+item1.key);
			item2 =tempItem.next;	System.out.println("rotateTriples,Key:"+item2.key);
			item3 =item2.next;		System.out.println("rotateTriples,Key:"+item3.key);
			
			
			item2.next = item3.next;
			item3.next = tempItem.next;
			preItem = item3;
			tempItem =item3.next; 
			
			}
		}
			
		}
}


