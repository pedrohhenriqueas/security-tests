package com.example.prol_educa.security.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.prol_educa.entities.Administrators;
import com.example.prol_educa.entities.Customers;
import com.example.prol_educa.repository.AdministratorsRepository;
import com.example.prol_educa.repository.CustomersRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	CustomersRepository customerRepository;

	@Autowired
	AdministratorsRepository administratorsRepository;
	
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
        

        // Depois tenta como administrador
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
