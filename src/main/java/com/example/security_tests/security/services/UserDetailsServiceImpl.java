package com.example.security_tests.security.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security_tests.entities.Administrators;
import com.example.security_tests.entities.Customers;
import com.example.security_tests.repository.AdministratorsRepository;
import com.example.security_tests.repository.CustomersRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	private final CustomersRepository customerRepository;
	private final AdministratorsRepository administratorsRepository;

	@Autowired
	public UserDetailsServiceImpl(CustomersRepository customerRepository,
									AdministratorsRepository administratorsRepository) {
		this.customerRepository = customerRepository;
		this.administratorsRepository = administratorsRepository;
	}

	public UserDetails loadCustomerByEmail(String email) throws UsernameNotFoundException{
		Customers customer = customerRepository.findByEmail(email);
		if(customer == null)
			throw new UsernameNotFoundException("Customer Not Found with email: " + email);
		    	
		return UserDetailsImpl.build(customer);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customers customer = customerRepository.findByEmail(email);
        if (customer != null) 
            return UserDetailsImpl.build(customer);
        
        Administrators admin = administratorsRepository.findByEmail(email);
        if (admin != null)
            return UserDetailsImpl.build(admin);

		throw new UsernameNotFoundException("User not found with email: " + email);
	}

	public UserDetails loadAdminByEmail(String email) throws UsernameNotFoundException {
		Administrators admin = administratorsRepository.findByEmail(email);
		if (admin == null)
			throw new UsernameNotFoundException("Admin Not Found with email: " + email);			

		return UserDetailsImpl.build(admin);
	}

}
