package USER;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

	String name = null;
	Usertypes usertype = null;
	int id = 0;
	ArrayList<User> userliste= new ArrayList<User>();

	public User(String _name,Usertypes _usertype, int _id){
		this.name = _name;
		this.usertype = _usertype;
		this.id = _id;
	}
	public String getName(){
		return this.name;
	}
	public Usertypes getUsertype(){
		return this.usertype;
	}
	public int getId(){
		return this.id;
	}
	public void setName(String _name){
		this.name = _name;
	}
	public void setUsertype(Usertypes _usertype){
		this.usertype = _usertype;
	}
	public void setId(int _id){
		this.id = _id;
	}

	public void addUser(String _name,int _usertype, int _id){
		User Karl = new User( _name ,_Usertypes ,_id);
		userliste.add(Karl);
	}
}
