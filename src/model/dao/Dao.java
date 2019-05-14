package model.dao;

import model.User;

public interface Dao<T> {
		
	public void delete(int index);
	
	public void lista();
	
	public T get(int index);

	void save(T object);

}
