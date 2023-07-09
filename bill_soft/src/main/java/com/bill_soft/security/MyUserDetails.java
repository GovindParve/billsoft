package com.bill_soft.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bill_soft.repository.EmployeeUserRepository;
import com.bill_soft.repository.LoginRepository;
@Service
public class MyUserDetails implements UserDetailsService{
	 @Autowired
	  private LoginRepository userRepository;
	 
	 @Autowired 
	 private EmployeeUserRepository employeerepository;
	 
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
	
	   String role= employeerepository.getRole(username);
	  
	   System.out.println("role" +role);
	
	    try
	    {
	    	

	    	
	    	if (role == null)
	 	   {
	 		  role="N/A";
	 	   }
	 	   
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	   
	    
	    if(role.equals("user"))
	    {
	    	 
	   
	   	    final com.bill_soft.entity.EmployeeUser user = employeerepository.findByUserName(username);
	   	    if(user==null)
	   	    {
	   		   throw new UsernameNotFoundException("User '" + username + "' not found");
	   	    }
	   
	   	 return org.springframework.security.core.userdetails.User//
			        .withUsername(username)//
			        .password(user.getPassword())//
			        .authorities(new ArrayList<>())//
			        .accountExpired(false)//
			        .accountLocked(false)//
			        .credentialsExpired(false)//
			        .disabled(false)//
			        .build();
	    }
	    
	    else
	    {
	    	
	     
		   	    final com.bill_soft.entity.UserDetails user = userRepository.findByUserName(username) ;
		   	    if(user==null)
		   	    		{
		   		   throw new UsernameNotFoundException("User '" + username + "' not found");
		   	    		}
	    
		   	 return org.springframework.security.core.userdetails.User//
				        .withUsername(username)//
				        .password(user.getPassword())//
				        .authorities(new ArrayList<>())//
				        .accountExpired(false)//
				        .accountLocked(false)//
				        .credentialsExpired(false)//
				        .disabled(false)//
				        .build();
	    }

	 }




//	 @Override
//	 public  EmployeeUser loadUserByUsername(String username)
//	    final com.bill_soft.entity.EmployeeUser user = employeerepository.findByUserName(username);   
//	 if (user == null) {
//	      throw new UsernameNotFoundException("User '" + username + "' not found");
//	    }
//	    return org.springframework.security.core.userdetails.User//
//		        .withUsername(username)//
//		        .password(user.getPassword())//
//		        .authorities(new ArrayList<>())//
//		        .accountExpired(false)//
//		        .accountLocked(false)//
//		        .credentialsExpired(false)//
//		        .disabled(false)//
//		        .build();


}
