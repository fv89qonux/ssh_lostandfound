package com.lin.lostandfound.vo;

import java.util.List;

import com.lin.lostandfound.domain.User;

public class UserModel {
	
	private List<User> users;
	
	public UserModel() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UserModel(List<User> users) {
        super();
        this.users = users;
    }

	@Override
	public String toString() {
		return "UserModel [users=" + users + "]";
	}
}
