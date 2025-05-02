package com.iorta.sboot.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iorta.sboot.dto.MyDetailsDto;
import com.iorta.sboot.dto.User;
import com.iorta.sboot.exception.UserNotFoundException;
import com.iorta.sboot.service.UserService;


@RestController
@RequestMapping("/users") //All endpoints start with /users

public class UserController {
	
	@Autowired
	UserService userService;
	
	//Get all users (Optional filtering using @RequestParam)
	//If no role is provided -> Return all users
	//If role is provided (?role=admin) -> Return only admin users
	@GetMapping("/getUsers")
	public String getUsers(@RequestParam(required = false) String role) {
		if (role != null) {
			return "Fetching all users with role: " + role;
		}
		return "Fetching all users";
	}
	//http://localhost:1900/users -> Fetches all users
	//http://localhost:1900/users?role=admin -> Fetches only admin users


	//Get a specific user (@PathVariable)
	@GetMapping("/getUserbyId/{name}")
	public String getUserbyId(@PathVariable(value="name") int id) {
		return "Fetching user with ID: " + id;
	}
	//{id} in the URL gets passed as a method parameter
	//(/users/5) -> Fetches user with ID 5
	//http://localhost:1900/users/10 -> Fetches user with ID 10
	
	@GetMapping("/getMyDetails/{name}/{age}")
	public String getUserbyId(@PathVariable(value="name") String firstName, @PathVariable int age) {
		return "My name is " + firstName + " and my age is " + age;
	}
	
	@GetMapping("/getMyFullName")
	public String getUserbyId(@RequestParam(value="fName") String firstName, 
							@RequestParam(value="lName") String secondName, 
							@RequestHeader(value="token", required = false) 
							String token) {
		//String response = "Invalid user";
		if(token != null && token.equals("123@")) {
			//return "My full name is " + firstName + " " + secondName;
		}
		return "My full name is " + firstName + " " + secondName;
		//return response;
	}

	//Add a new user (@RequestBody)
	@PostMapping
	public String addUser(@RequestBody User user) {
		return "User added: " + user.getName() + ", Role: " + user.getRole();
	}
	//Takes JSON data from the request body and creates a user.
		
	//Update user details (@PathVariable + @RequestBody)
	@PutMapping("/{id}")
	public String updateUser (@PathVariable int id, @RequestBody User user) {
		return "User with ID " + id + " updated to: " + user.getName() + ", Role: " + user.getRole();
	}
	//Uses @Pathvariable to find which user to update.
	//Uses @RequestBody to send updated user data.
	 
	//Delete a user (@PathVariable)
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id) {
		return "User with ID " + id + " deleted";
	}
	//Finds the user by ID and deletes them
	
	@PostMapping("/myDetails")
	public String myDetails(@RequestBody LinkedHashMap<String, String> map) {
		return userService.getMyDetails(map);
	}
	
	@PostMapping("/getMyDetails")
	public String myDetails(@RequestBody MyDetailsDto myDetails) {
		return userService.getMyDetailsService(myDetails);
	}
	
	@GetMapping("/{id}")
	public String getUser(@PathVariable Long id) {
		if (id == 0) {
			throw new UserNotFoundException("User with ID " + id + " not found");
		}
		return "User " + id; 
	}
}
