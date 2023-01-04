package com.mosalah.DAO;

import javax.sql.DataSource;

import com.mosalah.models.User;

public interface UserDAO {

	
	
	
	void register(User user);  
	void registerRole(User user);  
 public void setDataSource(DataSource dataSource);
	
}
