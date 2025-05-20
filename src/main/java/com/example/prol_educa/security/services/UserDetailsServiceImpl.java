package com.example.prol_educa.security.services;


import java.util.Optional;

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
		Customers customer = customerRepository.findByEmail(email)
        	.orElseThrow(() -> new UsernameNotFoundException("Customer Not Found with email: " + email));
        	
		return UserDetailsImpl.build(customer);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Customers> customerOpt = customerRepository.findByEmail(email);
        if (customerOpt.isPresent()) {
            return UserDetailsImpl.build(customerOpt.get());
        }

        // Depois tenta como administrador
        Optional<Administrators> adminOpt = administratorsRepository.findByEmail(email);
        if (adminOpt.isPresent()) {
            return UserDetailsImpl.build(adminOpt.get());
        }

		throw new UsernameNotFoundException("User not found with email: " + email);
	}

	public UserDetails loadAdminByEmail(String email) throws UsernameNotFoundException {
		Administrators admin = administratorsRepository.findByEmail(email)
			.orElseThrow(() -> new UsernameNotFoundException("Admin Not Found with email: " + email));

		return UserDetailsImpl.build(admin);
	}

}
