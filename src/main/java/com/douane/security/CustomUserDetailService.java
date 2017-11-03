package com.douane.security;

import java.util.*;

import com.douane.model.UserRole;
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

	//@Autowired
	private UserDAO userDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.douane.model.User user = userDao.findUser(username);
		List<GrantedAuthority> authorities =
				buildUserAuthority(user.getUserRole());

		return buildUserForAuthentication(user, authorities);

		//return new User(user.getName(), user.getPassword(), getAuthorities());
	}


	private User buildUserForAuthentication(com.douane.model.User user,
											List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(),
				user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}



	//LOGIC BEFORE USING ROLE BASED-DATABASE
	public Collection<? extends GrantedAuthority> getAuthorities(/*Integer role*/) {
		List<GrantedAuthority> authList = getGrantedAuthorities("ROLE_ADMIN");
		return authList;
		//List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		//return authList;
	}

	public List<String> getRoles(Integer role) {

		List<String> roles = new ArrayList<String>();

		if (role.intValue() == 1) {
			roles.add("ROLE_MODERATOR");
			roles.add("ROLE_ADMIN");
		} else if (role.intValue() == 2) {
			roles.add("ROLE_MODERATOR");
		}
		return roles;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(String role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();


		authorities.add(new SimpleGrantedAuthority(role));

		return authorities;
	}
	//public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
	// List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	//for (String role : roles) {
	// authorities.add(new SimpleGrantedAuthority(role));
	//}
	//return authorities;
	//}
}
