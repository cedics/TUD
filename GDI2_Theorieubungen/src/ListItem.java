
public class ListItem<T> {

	public T key;
	public ListItem<T>	next;
	
	public ListItem(T key, ListItem<T> next) {
		
		this.key = key;
		this.next = next;
	}
	
	
	
}
