package arrayListen;

import listen.List;
import listen.ListItem;

public class ArrayList<T> {

	private List<KeyItem<T>> list;
	private int N;
	
	/**
	 * constructor
	 */
	public ArrayList(int N){
		
		this.list = new List<KeyItem<T>>();
		this.N=N;
	}
	
	public void compress(){
		ListItem<KeyItem<T>> p = list.first;

		if(p.key.n > 0)
			
		while(true){
			if(p.key.n < (N)){
				if(p.next == null){
					return;
				}else{
					p.key.array[p.key.n - 1] = p.next.key.array[0];
				}
			}else{
				p = p.next;
			}
			
			
					
				
			
		}
	}
}
