package s3.vietan.user.management.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import s3.vietan.user.management.common.NotFoundException;
import s3.vietan.user.management.entity.UpdatedUserDTO;
import s3.vietan.user.management.entity.User;
import s3.vietan.user.management.entity.UserDTO;
import s3.vietan.user.management.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public List<UserDTO> findAll() {
		List<User> users = repository.findAll();
		List<UserDTO> userDTOs = new LinkedList<>();
		
		if(users.isEmpty()) {
			throw new NotFoundException("This is empty! for testing!");
		}
		
		for(User user : users) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(user, userDTO);
			userDTOs.add(userDTO);
		}
		
		return userDTOs;
	}

	public UserDTO getUser(int id) {
		
		Optional<User> userOpt = repository.findById(id);
		
		if(!userOpt.isPresent()) {
			throw new NotFoundException("User id is not valid");
		}
		
		User user = userOpt.get();
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(user, userDTO);
		
		return userDTO;
	}

	public UserDTO createUser(UserDTO userDTO) {
		
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		
		//check password & retype password 
		if(!user.getPassword().equals(user.getRetypePassword())) {
			throw new NotFoundException("Password mismatch!!!");
		}
		
		//check userName duplicated
		Optional<User> userOpt = repository.findByUsername(user.getUsername());
		if(userOpt.isPresent()) {
			throw new NotFoundException("User already created");
		}
		
		repository.save(user);
		user.setPassword(null);
		user.setRetypePassword(null);
		
		UserDTO dto = new UserDTO();
		BeanUtils.copyProperties(user, dto);
		
		return dto;
	}

	public boolean updateUser(int id, UpdatedUserDTO updatedUserDTO) {
		/*
		 * check db for existed id
		 */
		Optional<User> userOpt = repository.findById(id);
		if(!userOpt.isPresent()) {
			throw new NotFoundException("User id is not existed!");
		}
		User user = userOpt.get();
		
		/*
		 * check dto attributes with db attributes
		 */
		if(!user.getName().equals(updatedUserDTO.getName())) {
			user.setName(updatedUserDTO.getName());
		}
		
		if(!user.getPassword().equals(updatedUserDTO.getPassword())) {
			user.setPassword(updatedUserDTO.getPassword());
		}
		
		if(user.getPhoneNumber() != updatedUserDTO.getPhoneNumber()) {
			user.setPhoneNumber(updatedUserDTO.getPhoneNumber());
		}
		if(!user.getAddress().equals(updatedUserDTO.getAddress())) {
			user.setAddress(updatedUserDTO.getAddress());
		}
		
		/*
		 * update user update to db
		 */
		
		return repository.update(user) == 1 ? true : false;
	}

	public boolean deleteUser(int id) {
		/*
		 * check db for existed id
		 */
		Optional<User> userOpt = repository.findById(id);
		if(!userOpt.isPresent()) {
			throw new NotFoundException("User id is not existed!");
		}
		
		
		
		return repository.delete(userOpt.get()) == 1 ? true : false;
	}

}
