package com.example.security_tests.security.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.security_tests.entities.Administrators;
import com.example.security_tests.entities.Customers;

public class UserDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserDetailsImpl(Integer id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(Customers customers) {
		List<GrantedAuthority> authorities = customers.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getType().name())).collect(Collectors.toList());
		
		User user = new User(customers.getEmail(), customers.getPassword(), authorities);
		
		return new UserDetailsImpl(customers.getId(), user.getUsername(), user.getPassword(), authorities);
	}

	@Override
	public String getUsername() {
		return username;
	}

	public static UserDetailsImpl build(Administrators admin) {
		List<GrantedAuthority> authorities = admin.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getType().name()))
				.collect(Collectors.toList());

		User user = new User(admin.getEmail(), admin.getPassword(), authorities);

		return new UserDetailsImpl(admin.getId(), user.getUsername(), user.getPassword(), authorities);
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
