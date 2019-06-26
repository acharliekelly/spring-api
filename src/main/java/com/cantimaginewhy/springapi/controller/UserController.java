package com.cantimaginewhy.springapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cantimaginewhy.springapi.exception.ResourceNotFoundException;
import com.cantimaginewhy.springapi.model.User;
import com.cantimaginewhy.springapi.respository.UserRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Get all users list
	 * 
	 * @return the list
	 */
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	/**
	 * Get user by Id
	 * 
	 * @param userId the user id
	 * @return the user
	 * @throws ResourceNotFoundException the resource is not found
	 */
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		User user = getUser(userId);
		return ResponseEntity.ok().body(user);
	}
	
	/**
	 * Create user
	 * 
	 * @param user the user
	 * @return the user
	 */
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}
	
	/**
	 * Update the user
	 * 
	 * @param userId the user id
	 * @param userDetails the user details
	 * @return the response entity
	 * @throws ResourceNotFoundException the resource is not found
	 */
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(
			@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails)
			throws ResourceNotFoundException {
		
		User user = getUser(userId);
		
		user.setEmail(userDetails.getEmail());
		user.setLastName(userDetails.getLastName());
	    user.setFirstName(userDetails.getFirstName());
	    user.setUpdatedAt(new Date());
	    final User updatedUser = userRepository.save(user);
	    return ResponseEntity.ok(updatedUser);
	}
	
	/**
	 * Delete the user
	 * 
	 * @param userId the user id
	 * @return the response
	 * @throws Exception the resource is not found
	 */
	@DeleteMapping("/user/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
		User user = getUser(userId);
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	/**
	 * Get the user by id
	 * @param userId the user id
	 * @return the user
	 * @throws ResourceNotFoundException the resource is not found
	 */
	protected User getUser(Long userId) throws ResourceNotFoundException {
		return userRepository
				.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
		
	}
}
