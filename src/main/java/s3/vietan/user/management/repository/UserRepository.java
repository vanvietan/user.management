package s3.vietan.user.management.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import s3.vietan.user.management.datasource.DbQuery;
import s3.vietan.user.management.datasource.PostgreConnection;
import s3.vietan.user.management.entity.User;

@Repository
public class UserRepository {

	public List<User> findAll(){
		List<User> users = new LinkedList<User>();
		Connection connection = null;
		try {
			connection = PostgreConnection.getConnection();
			String query = DbQuery.findAll;
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhoneNumber(rs.getInt("phone_number"));
				user.setAddress(rs.getString("address"));
				user.setAge(rs.getInt("age"));
				
				users.add(user);
			}
			
		} catch (SQLException e) {
			System.out.println("Failed!");
			e.printStackTrace();
		}
		
		return users;
	}

	public Optional<User> findById(int id) {
		Connection connection = null;
		User user = new User();
		try {
			connection = PostgreConnection.getConnection();
			String query = DbQuery.findById;
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhoneNumber(rs.getInt("phone_number"));
				user.setAddress(rs.getString("address"));
				user.setAge(rs.getInt("age"));
				
			}
			
		} catch (SQLException e) {
			System.out.println("Failed!");
			e.printStackTrace();
		}
		
		return Optional.of(user);
	}

	public Optional<User> findByUsername(String username) {
		Connection connection = null;
		boolean hasUser = false;
		User user = null;
		try {
			connection = PostgreConnection.getConnection();
			String query = DbQuery.findByUsername;
			user = new User();
					
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhoneNumber(rs.getInt("phone_number"));
				user.setAddress(rs.getString("address"));
				user.setAge(rs.getInt("age"));
				
				hasUser =true;

			}
			
		} catch (SQLException e) {
			System.out.println("Failed!");
			e.printStackTrace();
		}
		
		if(hasUser) {
			return Optional.ofNullable(user);
		}else {
			return Optional.ofNullable(null);
		}
			
	}

	public User save(User user) {
		Connection connection = null;
		try {
			connection = PostgreConnection.getConnection();
			String query = DbQuery.save;
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, user.getName());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setInt(4, user.getPhoneNumber());
			statement.setString(5, user.getAddress());
			statement.setInt(6, user.getAge());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Failed!");
			e.printStackTrace();
		}
		return user;
	}
	
	public int update(User user) {
		Connection connection = null;
		try {
			connection = PostgreConnection.getConnection();
			String query = DbQuery.update;
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, user.getName());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setInt(4, user.getPhoneNumber());
			statement.setString(5, user.getAddress());
			statement.setInt(6, user.getAge());
			
			statement.setInt(7, user.getId());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Failed!");
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(User user) {
		Connection connection = null;
		try {
			connection = PostgreConnection.getConnection();
			String query = DbQuery.delete;
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, user.getId());
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Failed!");
			e.printStackTrace();
		}
		
		return 0;
		
	}

	

	
}
