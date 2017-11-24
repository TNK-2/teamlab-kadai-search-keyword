package teamlab.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SearchList<E> implements List<E>{
	
	private List<E> list = null;
	
	private int hitcount = 0;
	
	public SearchList(){
		list = new ArrayList<>();
	}
	
	public SearchList(int num){
		list = new ArrayList<>(num);
	}

	@Override
	public boolean add(E arg0) {
		return list.add(arg0);
	}

	@Override
	public void add(int arg0, E arg1) {
		// Do Nothing
		
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// Do Nothing
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		// Do Nothing
		return false;
	}

	@Override
	public void clear() {
		// Do Nothing
		
	}

	@Override
	public boolean contains(Object arg0) {
		// Do Nothing
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// Do Nothing
		return false;
	}

	@Override
	public E get(int arg0) {
		// Do Nothing
		return null;
	}

	@Override
	public int indexOf(Object arg0) {
		// Do Nothing
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// Do Nothing
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// Do Nothing
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// Do Nothing
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// Do Nothing
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int arg0) {
		// Do Nothing
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// Do Nothing
		return false;
	}

	@Override
	public E remove(int arg0) {
		// Do Nothing
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// Do Nothing
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// Do Nothing
		return false;
	}

	@Override
	public E set(int arg0, E arg1) {
		// Do Nothing
		return null;
	}
	
	public void setHits(int hitcount) {
		this.hitcount = hitcount;
	}

	@Override
	public int size() {
		return hitcount;
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		return list.subList(arg0, arg1);
	}

	@Override
	public Object[] toArray() {
		// Do Nothing
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// Do Nothing
		return null;
	}

}
