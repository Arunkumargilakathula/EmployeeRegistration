package com.tcl.service;



import com.tcl.entity.User;

public interface UserService {
	    User add(User user);
	    //List<UserRecord> getAllUsers();
	    void delete(String email);
	   User getUser(String email);
	    User update(User user);
	}


