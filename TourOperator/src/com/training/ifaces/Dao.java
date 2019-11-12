package com.training.ifaces;

import java.util.List;
import java.sql.SQLException;

public interface Dao<T> {
	
       public int add(T t)throws SQLException; 
       public T findById(int id, String password) throws SQLException;

}

