package com.scientificGames.scientific.Users;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UsersController {
	
	private ArrayList<User> users = new ArrayList<User>();
	
	public UsersController() {
		
		// Hard coded users
		this.users.add(new User("Test","test"));
		this.users.add(new User("Sanyi","sanyiPwd42"));
		this.users.add(new User("Béla","belaJelszava2022"));
	}
	
	// URI /users
	@GetMapping( path = "/users")
	public ArrayList<User> getUsers() {
		return this.users; // Should it be cloned? Efficency vs Security
	}
	
	
	// TODO: Make this much more secure, and use (make sure) ENCRYPTING
	@GetMapping( path = "/users/{name}/{pwd}")
	public Boolean checkPassword(@PathVariable String name, @PathVariable String pwd) {
		System.out.println("Login try - name:" + name + " |password:" + pwd);
		for(int i = 0; i < this.users.size(); i++) {
			//System.out.println(this.users.get(i).name + " ; " + this.users.get(i).pwd);
			if(this.users.get(i).name.equals(name) && this.users.get(i).pwd.equals(pwd)) return true; 
		}
		return false;
	}
	
}
