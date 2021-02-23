package com.cg.oes.service;

import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.oes.entity.Admin;
import com.cg.oes.repository.IAdminRepository;

@Service
@Transactional 
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	private IAdminRepository adminRepository;

	@Override
	public String login(Admin admin) {
		 String returnString = "Invalid Credentials";
			
			try
			{
			   Admin admin1 = adminRepository.findById(admin.getId()).get();
			System.out.println(admin);
			  if(admin1.getPassword().equals(admin.getPassword()))
				{
					returnString="Login Successful";
				 
					return returnString;
				}
			return returnString;
			
			}
			catch (NoSuchElementException ex)
			{
				return "Invalid Admin";
			}

	}

}

