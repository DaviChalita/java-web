package model.dao;

import java.util.*;

import model.User;

public abstract class UserDao implements Dao{
	
	private List<User> usuarios;
	
	
	public void save(User user) {
		usuarios.add(user);
		
	}
	
	@Override
	public void delete(int index) {
		usuarios.remove(index);
		
	}
	
	@Override
	public void lista() {
		this.usuarios.forEach(usuario -> {
			System.out.println(usuario);
	});
		
	}
	
	@Override
	public Object get(int index) {
		return this.usuarios.get(index);
	}

	
}
