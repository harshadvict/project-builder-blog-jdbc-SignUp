package dao;
import model.*;
interface UserDaoInterface{
	int signUp(User user);
	boolean loginUser(User user);
}
