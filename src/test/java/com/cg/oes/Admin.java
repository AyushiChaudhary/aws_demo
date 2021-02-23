package com.cg.oes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.oes.repository.IAdminRepository;
import com.cg.oes.service.AdminServiceImpl;
import com.cg.oes.service.IAdminService;

@SpringBootTest
class Admin {


	
	@Autowired
	private IAdminService service;
	
	@MockBean
	private IAdminRepository dao1;
	
	@InjectMocks
    AdminServiceImpl adminServiceImpl;

/*	@Test
	public void adminLoginTest(Admin admin) throws Exception {
		Admin admin1 = new Admin();
		IAdminService service = mock(AdminServiceImpl.class);
		admin1=admin.se
		assertEquals("login Succesfull", admin);
	}

	*/
}
