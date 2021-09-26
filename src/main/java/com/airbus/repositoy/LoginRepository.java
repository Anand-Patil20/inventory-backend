package com.airbus.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airbus.domain.User;
@Repository
public interface LoginRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);
	@Query("select u from User u where u.username= ?1 and u.password= ?2")
	User checkIfExist(String username, String password);

}
