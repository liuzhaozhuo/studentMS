package service;

import entity.Users;

//用户业务逻辑接口
public interface IUsersDAO {

	//用户登录
	public boolean usersLogin(Users u);
}
