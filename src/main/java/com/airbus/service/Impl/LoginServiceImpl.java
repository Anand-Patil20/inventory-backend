package com.airbus.service.Impl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.airbus.domain.User;
import com.airbus.repositoy.LoginRepository;
import com.airbus.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService,UserDetailsService {

	@Autowired
	LoginRepository loginRepository;
	
	@Override
	public User saveUser(User user) {
		User checkUser=loginRepository.findByUsername(user.getUsername());
		User addUser=null;
		if(checkUser!=null &&checkUser.getId()!=null) {
			return null;	
		}else {
			addUser=loginRepository.save(user);
		}
		return addUser;
	}

//	@Override
//	public String authenticate(String authValue) {
//		String token=null;
//		JSONObject auth=null;
//		try {
//			auth = new JSONObject(authValue);
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		
//		User checkUser=loginRepository.checkIfExist(auth.optString("username"),auth.optString("password"));
//		if(checkUser==null || checkUser.getId()==null) {
//			return null;	
//		}else {
//			
//		}
//		
//		return token;
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=loginRepository.findByUsername(username);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}

}
