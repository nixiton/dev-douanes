package com.douane.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.douane.user.dao.UserDAO;

@Service
@Transactional(readOnly=true)
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserDAO userDao;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.douane.model.User user = userDao.findUser(username);
		
		
	        return new User(user.getName(), user.getPassword(), getAuthorities());
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authList = getGrantedAuthorities("ROLE_ADMIN");
        return authList;
    }
	 public static List<GrantedAuthority> getGrantedAuthorities(String role) {
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	       
	       
	            authorities.add(new SimpleGrantedAuthority(role));
	       
	        return authorities;
	    }
}
