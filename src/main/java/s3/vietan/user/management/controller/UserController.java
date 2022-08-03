package s3.vietan.user.management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import s3.vietan.user.management.common.ResponseHandler;
import s3.vietan.user.management.entity.UpdatedUserDTO;
import s3.vietan.user.management.entity.UserDTO;
import s3.vietan.user.management.service.UserService;

@RestController
@RequestMapping(path="/api")
public class UserController {
	
	@Autowired
	private UserService service;
	
	/*
	 * CRUD API
	 */
	
	@GetMapping(value="/user")
	public ResponseEntity<Object> findAllUser(){
		List<UserDTO> users = service.findAll();
		
		return ResponseHandler.getResponse(users, HttpStatus.OK);
	}
	
	@GetMapping(value="/user/{userId}")
	public ResponseEntity<Object> getUser(@PathVariable("userId") int id){
		UserDTO getUser = service.getUser(id);
		
		return ResponseHandler.getResponse(getUser, HttpStatus.OK);
	}
	
	@PostMapping(value="/user")
	public ResponseEntity<Object> createUser(
			@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		
		UserDTO createdUser = service.createUser(userDTO);
		
		return ResponseHandler.getResponse(createdUser, HttpStatus.OK);
	}
	
	@PutMapping(value="/user/{userId}")
	public ResponseEntity<Object> updateUser(
			@PathVariable("userId") int id, @Valid @RequestBody UpdatedUserDTO updatedUserDTO, BindingResult bindingResult){
		
		service.updateUser(id, updatedUserDTO);
		
		return ResponseHandler.getResponse("Updated User Successfully", HttpStatus.OK);
	}
	
	@DeleteMapping(value="/user/{userId}")
	public ResponseEntity<Object> deleteUser(@PathVariable("userId") int id){
		
		service.deleteUser(id);
		
		return ResponseHandler.getResponse("Deleted User Successfully",HttpStatus.OK);
	}
	
}
